package edu.byui.PET.camera;

import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.awt.*;
import java.awt.color.*;

/**
 * 
 * @author kirnack
 */
public abstract class Camera
{

   /**
    * 
    */
   protected Configuration config = null;
   /**
    * 
    */
   protected BufferedImage image = null;
   /**
    * 
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
    * 
    * @return
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
    * 
    * @return
    * @throws IOException
    */
   public abstract boolean captureImage() throws IOException;

   /**
    * 
    * @param pFilename
    * @return
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
    * 
    * @return
    */
   public boolean saveJPEG()
   {
      return saveJPEG("converted");
   }

   /**
    * 
    * @param pConfig
    * @return
    */
   public boolean setConfiguration(Configuration pConfig)
   {
      config = pConfig;
      return config.configure(this);
   }
}
