/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.gps;

/**
 *
 * @author Kyle
 */
public class GPSTest
{
   public static void main(String[] arg)
   {
      System.out.println(new GPS().getGPSString());
      
      /*
      string deg = '?';
      string min = '?';
      string space = ' ';
      string buffer;
      string justLocation;
      GPS myGPS = new GPS();
      buffer = myGPS.getGPSString();
      justLocation = buffer[16] + buffer[17] + deg  + space + buffer[18] + 
      buffer[19] + buffer[20] + buffer[21] + buffer[22] + buffer[23]
      + buffer[24] + min + buffer[26] + space + buffer[28] + buffer[29] + 
      buffer[30] + deg + space + buffer[31] + buffer[32] + buffer[33] + 
      buffer[34] + buffer[35] + buffer[36] + buffer[37] + min + buffer[39];
      */
      
   }
}
