package edu.byui.PET.camera;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.awt.*;
import java.awt.color.*;

/**
 * A Camera class used to represent a camera in the PET software. This is an
 * abstract class. The captureImage() function in not implemented, due to the
 * nature that each camera will have a different way of processing the pixel
 * data.
 * 
 * The configuration of the camera is stored in a Configuration object.
 * 
 * @author kirnack
 */
public abstract class Camera
{

   /**
    * Configuration of the camera.
    */
   protected Configuration config = null;
   /**
    * A buffered image containing the current image.
    */
   protected BufferedImage image = null;
   /**
    * Contains the byte values of the current image.
    */
   protected byte[] data = null;

   private boolean checkConfig()
   {
      return config != null;
   }

   private boolean checkImage()
   {
      return image != null;
   }

   private boolean checkData()
   {
      return data != null;
   }

   /**
    * Returns the current image in a BufferedImage.
    * 
    * @return The current image as a BufferedImage.
    * @throws Exception
    */
   public BufferedImage getImage() throws Exception
   {
      if (checkConfig())
      {
         if (checkImage())
         {
            return image;
         }
         else
         {
            throw new Exception("Image was not captured. No image to display.");
         }
      }
      else
      {
         throw new Exception("No Configuration. Please set a Configuration.");
      }
   }

   /**
    * Abstract method that changes the current image to a new image.
    * 
    * @return True if the capture was successful.
    * @throws IOException
    */
   public abstract boolean captureImage() throws IOException;

   /**
    * Save the image to a JPEG.
    * 
    * @param pFilename Filename of the created JPEG.
    * @return True if the write was successful.
    */
   public boolean saveJPEG(String pFilename)
   {
      if (checkImage())
      {
         try
         {
            ImageIO.write(image, "jpg", new File(pFilename + ".jpg"));
            return true;
         }
         catch (Exception e)
         {
            e.printStackTrace();
         }
      }
      return false;
   }

   /**
    * Save the image to a JPEG called "converted.jpg".
    * 
    * @return True if the write was successful.
    */
   public boolean saveJPEG()
   {
      return saveJPEG("converted");
   }

   /**
    * Changes the Camera's configuration.
    * 
    * @param pConfig The new Configuration for the camera.
    * @return True if the configuration was set correctly.
    */
   public boolean setConfiguration(Configuration pConfig)
   {
      config = pConfig;
      return config.configure(this);
   }
}
