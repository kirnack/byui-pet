package edu.byui.PET.camera;

import java.awt.color.*;

/**
 * Represents the width, height, bits per pixel and ColorSpcae of the images
 * from a Camera.
 * 
 * @author Bryon Rogers
 */
public class Configuration
{

   /**
    * Width of the images in pixels.
    */
   protected int xRes = 0;
   
   /**
    * Height of the images in pixels.
    */
   protected int yRes = 0;
   
   /**
    * Number of bits per pixel
    */
   protected int bitsPerPixel = 0;
   
   /**
    * The number of bits for each color.
    */
   protected int[] nBits = null;
   
   /**
    * ColorSpace of the images.
    */
   protected ColorSpace cs = null;

   /**
    * Returns the width of the images from the camera.
    * 
    * @return The width of the images.
    */
   public int getXRes()
   {
      return xRes;
   }

   /**
    * Sets the width of the images.
    * 
    * @param n New width of the images.
    */
   public void setXRes(int n)
   {
      xRes = n;
   }

   /**
    * Returns the height of the images from the camera.
    * 
    * @return The height of the images.
    */
   public int getYRes()
   {
      return yRes;
   }

   /**
    * Sets the height of the images.
    * 
    * @param n New height of the images.
    */
   public void setYRes(int n)
   {
      yRes = n;
   }

   /**
    * Returns the number of bits per pixel.
    * 
    * @return The number of bits per pixel in an integer.
    */
   public int getBPP()
   {
      return bitsPerPixel;
   }

   /**
    * Returns an array containing the number of bits per color.
    * 
    * @return An integer array with the number of bits for each color.
    */
   public int[] getNBits()
   {
      return nBits;
   }

   /**
    * Returns the @see ColorSpace associated with the images.
    * 
    * @return The @see ColorSpace associated with the images.
    */
   public ColorSpace getColorSpace()
   {
      return cs;
   }

   /**
    * 
    * @param pCam The camera to configure with the settings.
    * @return True if the configuration was successful.
    */
   public boolean configure(Camera pCam)
   {
      return true;
   }
}
