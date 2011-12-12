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
   
   public boolean setImage(BufferedImage pBuff)
   {
      image = pBuff;
      return true;
   }
   
   @Override
   public boolean captureImage() throws IOException
   {
      return true;
   }
           
}
