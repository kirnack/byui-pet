package edu.byui.PET.camera;

import java.awt.color.*;

/**
 * 
 * @author kirnack
 */
public class Configuration
{

   /**
    * 
    */
   protected int xRes = 0;
   /**
    * 
    */
   protected int yRes = 0;
   /**
    * 
    */
   protected int bitsPerPixel = 0;
   /**
    * 
    */
   protected int[] nBits = null;
   /**
    * 
    */
   protected ColorSpace cs = null;

   /**
    * 
    * @return
    */
   public int getXRes()
   {
      return xRes;
   }

   /**
    * 
    * @param n
    */
   public void setXRes(int n)
   {
      xRes = n;
   }

   /**
    * 
    * @return
    */
   public int getYRes()
   {
      return yRes;
   }

   /**
    * 
    * @param n
    */
   public void setYRes(int n)
   {
      yRes = n;
   }

   /**
    * 
    * @return
    */
   public int getBPP()
   {
      return bitsPerPixel;
   }

   /**
    * 
    * @return
    */
   public int[] getNBits()
   {
      return nBits;
   }

   /**
    * 
    * @return
    */
   public ColorSpace getColorSpace()
   {
      return cs;
   }

   /**
    * 
    * @param pCam
    * @return
    */
   public boolean configure(Camera pCam)
   {
      return true;
   }
}
