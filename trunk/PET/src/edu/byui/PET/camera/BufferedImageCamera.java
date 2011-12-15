/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.camera;

import edu.byui.PET.PETAPP;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author brogers3
 */
public class BufferedImageCamera extends Camera
{
   /**
    * Creates a BufferedImageCamera and fills it with the image pointed to by
    * pFile.
    * 
    * @param pFile The image to load into the camera.
    */
   public BufferedImageCamera(File pFile)
   {
      try
      {
         super.image = ImageIO.read(pFile);
      }
      catch(Exception E)
      {
         super.image = null;
      }
      super.config = new Configuration();
   }
   
   /**
    * Creates a default BufferedImageCamera using a default image 
    * and configuration of PETConfiguration.GRAY_SCALE.
    */
   public BufferedImageCamera()
   {
      try
      {
         super.image = ImageIO.read(PETAPP.class.getResourceAsStream("resources/plateImageHolder.jpg"));
      }
      catch (Exception ex)
      {
         Logger.getLogger(BufferedImageCamera.class.getName()).log(Level.SEVERE, null, ex);
      }
      super.config = new Configuration();
   }
   
   /**
    * Allows you to set the BufferedImage in the camera.
    * 
    * @param pFile File to read the BufferedImage from.
    * @return True if the BufferedImage was set.
    */
   public boolean setImage(File pFile)
   {
      try
      {
         super.image = ImageIO.read(pFile);
         return true;
      }
      catch(Exception e)
      {
         return false;
      }
   }
   
   /**
    * Allows you to set the BufferedImage in the camera.
    * 
    * @param pBuff
    * @return True if the BufferedImage was set.
    */
   public boolean setImage(BufferedImage pBuff)
   {
      image = pBuff;
      return true;
   }
   /**
    * For a BufferedImageCamera this function will always return true. There
    * is no camera to actually talk to, so we do not need to process any
    * camera data.
    * 
    * @return True if the image was captured.
    * @throws IOException 
    */
   @Override
   public boolean captureImage() throws IOException
   {
      return true;
   }
           
}
