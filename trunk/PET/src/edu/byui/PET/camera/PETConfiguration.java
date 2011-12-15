package edu.byui.PET.camera;

import java.awt.color.*;

/**
 * An implementation of Configuration to set the needed configurations
 * for converting pixel data to a BufferedImage.
 * 
 * @author kirnack
 */
public class PETConfiguration extends Configuration
{
   /**
    * Value to have a gray scale configuration.
    */
   public static final int GRAY_SCALE = 1;
   /**
    * Value to have a Bayer RG8 configuration.
    * @deprecated Due to Bayer not being a straight forward RGB data format.
    */
   @Deprecated
   public static final int BAYER_RG8 = 2;
   
   /**
    * Creates a PETConfiguration of the given type.
    * 
    * @param ImageType Configuration type integer.
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

