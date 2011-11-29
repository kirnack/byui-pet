/*
------------------------------------------------------------------------
JavaANPR - Automatic Number Plate Recognition System for Java
------------------------------------------------------------------------

This file is a part of the JavaANPR, licensed under the terms of the
Educational Community License

Copyright (c) 2006-2007 Ondrej Martinsky. All rights reserved

This Original Work, including software, source code, documents, or
other related items, is being provided by the copyright holder(s)
subject to the terms of the Educational Community License. By
obtaining, using and/or copying this Original Work, you agree that you
have read, understand, and will comply with the following terms and
conditions of the Educational Community License:

Permission to use, copy, modify, merge, publish, distribute, and
sublicense this Original Work and its documentation, with or without
modification, for any purpose, and without fee or royalty to the
copyright holder(s) is hereby granted, provided that you include the
following on ALL copies of the Original Work or portions thereof,
including modifications or derivatives, that you make:

# The full text of the Educational Community License in a location
viewable to users of the redistributed or derivative work.

# Any pre-existing intellectual property disclaimers, notices, or terms
and conditions.

# Notice of any changes or modifications to the Original Work,
including the date the changes were made.

# Any modifications of the Original Work must be distributed in such a
manner as to avoid any confusion with the Original Work of the
copyright holders.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

The name and trademarks of copyright holder(s) may NOT be used in
advertising or publicity pertaining to the Original or Derivative Works
without specific, written prior permission. Title to copyright in the
Original Work and any associated documentation will at all times remain
with the copyright holders.

If you want to alter upon this work, you MUST attribute it in
a) all source files
b) on every place, where is the copyright of derivated work
exactly by the following label :

---- label begin ----
This work is a derivate of the JavaANPR. JavaANPR is a intellectual
property of Ondrej Martinsky. Please visit http://javaanpr.sourceforge.net
for more info about JavaANPR.
----  label end  ----

------------------------------------------------------------------------
                                         http://javaanpr.sourceforge.net
------------------------------------------------------------------------
*/


package javaanpr.imageanalysis;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javaanpr.intelligence.Intelligence;

public class PlateGraph extends Graph {

        Plate handle;

        private static double plategraph_rel_minpeaksize =
                Intelligence.configurator.getDoubleProperty("plategraph_rel_minpeaksize");
        private static double peakFootConstant =
                Intelligence.configurator.getDoubleProperty("plategraph_peakfootconstant");

        public PlateGraph(Plate handle) {
            this.handle = handle; // nesie odkaz na obrazok (Plate), ku ktoremu sa graf vztahuje
        }

        public class SpaceComparer implements Comparator {
            Vector<Float> yValues = null;

            public SpaceComparer(Vector<Float> yValues) {
                this.yValues = yValues;
            }

            private float getPeakValue(Object peak) {
                return ((Peak)peak).getCenter(); // left > right
                //return this.yValues.elementAt( ((Peak)peak).center()  );
            }

            public int compare(Object peak1, Object peak2) {
                double comparison = this.getPeakValue(peak2) - this.getPeakValue(peak1);
                if (comparison < 0) return 1;
                if (comparison > 0) return -1;
                return 0;
            }
        }

        public Vector<Peak> findPeaks(int count) {
            Vector<Peak> spacesTemp = new Vector<Peak>();

            // uprava grafu pred segmentaciou :
            // 1. zistime average value a maxval
            // 2. upravime minval ako
            //  diffVal = average - (maxval - average) = 2average - maxval
            //  val -= diffVal

            float diffGVal = 2 * this.getAverageValue() - this.getMaxValue();

            Vector<Float> yValuesNew = new Vector<Float>();
            for (Float f : this.yValues) {
                yValuesNew.add(f.floatValue()-diffGVal);
            }
            this.yValues = yValuesNew;

            this.deActualizeFlags();
            // end

            for (int c=0; c<count; c++) { // for count
                float maxValue = 0.0f;
                int maxIndex = 0;
                for (int i=0; i<this.yValues.size(); i++) { // zlava doprava
                    if (allowedInterval(spacesTemp, i)) { // ak potencialny vrchol sa nachadza vo "volnom" intervale, ktory nespada pod ine vrcholy
                        if (this.yValues.elementAt(i) >= maxValue) {
                            maxValue = this.yValues.elementAt(i);
                            maxIndex = i;
                        }
                    }
                } // end for int 0->max
                // nasli sme najvacsi peak
                // 0.75 mensie cislo znamena tendenciu znaky sekat, vacsie cislo zase tendenciu nespravne zdruzovat
                if (yValues.elementAt(maxIndex) < plategraph_rel_minpeaksize * this.getMaxValue()) break;

                int leftIndex = indexOfLeftPeakRel(maxIndex, peakFootConstant); //urci sirku detekovanej medzery
                int rightIndex = indexOfRightPeakRel(maxIndex, peakFootConstant);

                spacesTemp.add(new Peak(
                        Math.max(0,leftIndex),
                        maxIndex,
                        Math.min(this.yValues.size()-1,rightIndex)
                        ));
            } // end for count

            // treba filtrovat kandidatov, ktory nezodpovedaju proporciam MEDZERY
            Vector<Peak> spaces = new Vector<Peak>();
            for (Peak p : spacesTemp) {
                if (p.getDiff() < 1 * this.handle.getHeight() // medzera nesmie byt siroka
                    ) spaces.add(p);// znacka ok, bereme ju
                    //else outPeaksFiltered.add(p);// znacka ok, bereme ju
            }

            // Vector<Peak> space OBSAHUJE MEDZERY, zoradime LEFT -> RIGHT
            Collections.sort(spaces, (Comparator<? super Graph.Peak>)
                                     new SpaceComparer(this.yValues));



// outPeaksFiltered teraz obsahuje MEDZERY ... v nasledujucom kode
            // ich transformujeme na pismena
            Vector<Peak> chars = new Vector<Peak>();

/*
 *      + +   +++           +++             +
 *       + +++   +         +   +           +
 *                +       +     +         +
 *                 +     +       +      ++
 *                  +   +         +   ++
 *                   +++           +++
 *                    |      |      1        |     2 ....
 *                    |
 *                    +--> 1. local minimum
 *
 */

            // Added by Kyle Atkinson 2011.11.14
            // Attempt to prevent segmentation within characters
            double averageWidth = 0.0;

            // zapocitame aj znak od medzery na lavo :
            if (spaces.size()!=0) {
                // detekujeme 1. lokalne minimum na grafe
                // 3 = leftmargin
                int minIndex = this.getMinValueIndex(0,spaces.elementAt(0).getCenter());
                //System.out.println("minindex found at " + minIndex + " in interval 0 - " + outPeaksFiltered.elementAt(0).getCenter());
                // hladame index do lava od minindex
                int leftIndex = 0;
//                for (int i=minIndex; i>=0; i--) {
//                    leftIndex = i;
//                    if (this.yValues.elementAt(i) >
//                        0.9 * this.yValues.elementAt(
//                                outPeaksFiltered.elementAt(0).getCenter()
//                                                    )
//                       ) break;
//                }

                Peak first = new Peak(leftIndex/*0*/,spaces.elementAt(0).getCenter());
                // Altered by Kyle Atkinson 2011.11.14
                if (first.getDiff()>0)
                {
                    averageWidth += first.getDiff();
                    //System.err.println(averageWidth);
                    chars.add(first);
                }
            }

            for (int i=0; i<spaces.size() - 1; i++) {
                int left = spaces.elementAt(i).getCenter();
                int right = spaces.elementAt(i+1).getCenter();
                chars.add(new Peak(left,right));
                // Altered by Kyle Atkinson 2011.11.14
                averageWidth += right-left;
                //System.err.println(right-left);
            }

            // znak ktory je napravo od poslednej medzery :
            if (spaces.size()!=0) {
                Peak last = new Peak(
                    spaces.elementAt(spaces.size()-1).getCenter(),
                    this.yValues.size()-1
                        );
                if (last.getDiff()>0)
                {
                    averageWidth += last.getDiff();
                    //System.err.println(last.getDiff());
                    chars.add(last);
                }
            }

            // Added by Kyle Atkinson 2011.11.14
            // Attempt to improve character segmentation
            averageWidth /= chars.size();
            double disp = Intelligence.configurator.getDoubleProperty("intelligence_maxCharWidthDispersion");
            double minWidth = averageWidth * (1.0-disp);
            double maxWidth = averageWidth * (1.0+disp);
            disp *= averageWidth;

            for (int i = 0; i < chars.size(); i++) {
                if (chars.elementAt(i).getDiff() < minWidth) {
                    // If two narrow spacings are next to each other, combine them
                    // This should help prevent splitting letters (like "U") in two
                    if (i < (chars.size()-1) && chars.elementAt(i+1).getDiff() < minWidth) {
                        Peak temp = chars.elementAt(i);
                        temp.setRight(chars.elementAt(i+1).getRight());
                        temp.setCenter((temp.getLeft()+temp.getRight())/2);
                        chars.removeElementAt(i+1);
                        //System.err.println("Combined Items "+i+" and "+(i+1));
                    }/* Reduced Accuracy once wildcards were added to output
                    // If only one narrow spacing is found, remove it
                     *else {
                     *   //System.err.println("Removed Item "+i);
                     *   chars.removeElementAt(i);
                     *   i--;
                    }*/
                }
                else if (chars.elementAt(i).getDiff() > maxWidth) {
                    // Guess how many characters are in the spacing
                    int tempDiff = chars.elementAt(i).getDiff();
                    int numChars = (int) Math.round(tempDiff/averageWidth);

                    // It's a good guess
                    if (Math.abs((numChars*averageWidth) - tempDiff) <= numChars*disp) {
                        int tempLeft = chars.elementAt(i).getLeft();
                        int tempRight = chars.elementAt(i).getRight();
                        int newDiff = tempDiff / numChars;
                        for (int j = 1; j < numChars; j++) {
                            chars.add(i+j, new Peak(tempLeft+newDiff*j,tempLeft+newDiff*(j+1)));
                        }
                        chars.elementAt(i).setRight(tempLeft+newDiff);
                        chars.elementAt(i).setCenter((2*tempLeft+newDiff)/2);
                        //System.err.println("Split Item "+i+" in "+numChars+" pieces");
                    }
                    // Otherwise, find a peak in brightness
                    else {
                        Peak temp = chars.elementAt(i);
                        float maxVal = 0.0f;
                        // If a maximum is not found, cut the spacing in half
                        int maxIndex = temp.getCenter();
                        for (int j = (int) (temp.getLeft() + disp);
                                j < temp.getLeft() + averageWidth + disp; j++) {
                            if (this.yValues.elementAt(j) > maxVal) {
                                maxVal = this.yValues.elementAt(j);
                                maxIndex = j;
                            }
                        }

                        chars.add(i+1, new Peak(maxIndex,temp.getRight()));
                        temp.setRight(maxIndex);
                        temp.setCenter((temp.getLeft()+maxIndex)/2);
                        //System.err.println("Split Item "+i+" at "+maxIndex);
                    }
                }
            }

            super.peaks = chars;
            return chars;

        }
//        public int indexOfLeftPeak(int peak) {
//            int index=peak;
//            int counter = 0;
//            for (int i=peak; i>=0; i--) {
//                index = i;
//                if (yValues.elementAt(index) < 0.7 * yValues.elementAt(peak) ) break;
//            }
//            return Math.max(0,index);
//        }
//        public int indexOfRightPeak(int peak) {
//            int index=peak;
//            int counter = 0;
//            for (int i=peak; i<yValues.size(); i++) {
//                index = i;
//                if (yValues.elementAt(index) < 0.7 * yValues.elementAt(peak) ) break;
//            }
//            return Math.min(yValues.size(), index);
//        }

//        public float minValInInterval(float a, float b) {
//            int ia = (int)(a*yValues.size());
//            int ib = (int)(b*yValues.size());
//            float min = Float.POSITIVE_INFINITY;
//            for (int i=ia; i<ib;i++) {
//                min = Math.min(min, yValues.elementAt(i));
//            }
//            return min;
//        }
//        public float maxValInInterval(float a, float b) {
//            int ia = (int)(a*yValues.size());
//            int ib = (int)(b*yValues.size());
//            float max = 0;
//            for (int i=ia; i<ib;i++) {
//                max = Math.max(max, yValues.elementAt(i));
//            }
//            return max;
//        }

}
