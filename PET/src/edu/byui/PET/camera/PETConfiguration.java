package edu.byui.PET.camera;

import java.awt.color.*;

/**
 * 
 * @author kirnack
 */
public class PETConfiguration extends Configuration
{
   /**
    * f
    */
   public static final int GRAY_SCALE = 1;
   /**
    * 
    */
   public static final int BAYER_RG8 = 2;
   
   /**
    * 
    * @param ImageType
    */
   public PETConfiguration(int ImageType)
   {
      int colorSpace;
      switch(ImageType)
      {
         case BAYER_RG8:
            colorSpace = ColorSpace.CS_LINEAR_RGB;
            bitsPerPixel = 8 * 1;
            nBits = new int[] { 8 };
            break;
         case GRAY_SCALE:
         default:
            colorSpace = ColorSpace.CS_GRAY;
            bitsPerPixel = 8;
            nBits = new int[] { 8 };
      }
      cs = ColorSpace.getInstance(colorSpace);
   }
}

