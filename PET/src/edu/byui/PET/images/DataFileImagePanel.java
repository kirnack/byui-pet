package edu.byui.PET.images;

import javax.swing.ImageIcon;
import java.awt.image.*;
import java.awt.Image;
import edu.byui.PET.camera.*;

/**
 * Reads pixel data from pixel data files.
 * @author Bryon Rogers
 */
@SuppressWarnings("serial")
public class DataFileImagePanel extends ImagePanel
{

   PETFileCamera cam;

   /**
    * Creates a default DataFileImagePanel with a GRAY_SCALE configuration
    * and loads test8.data into memory.
    * @throws Exception
    */
   public DataFileImagePanel() throws Exception
   {
      this("test8.data", PETConfiguration.GRAY_SCALE);
   }

   /**
    * Creates a DataFileImagePanel with colorType configuration and loads pFile
    * into the camera.
    * 
    * @param pFile Path to file to load.
    * @param colorType Configuration type.
    * @throws Exception
    */
   public DataFileImagePanel(String pFile, int colorType) throws Exception
   {

      cam = new PETFileCamera(pFile, colorType);
      cam.captureImage();
      image = new ImageIcon(cam.getImage());
   }

   /**
    * Changes the loaded file to pFile.
    * 
    * @param pFile Path to file to load.
    * @return True if load was successful.
    * @throws Exception
    */
   public boolean changeFile(String pFile) throws Exception
   {
      if (cam.changeFile(pFile))
      {
         if (cam.captureImage())
         {
            image = new ImageIcon(cam.getImage());
            return true;
         }
      }
      return false;
   }

   /**
    * Saves the current image as a JPEG named Converted.jpg.
    * 
    * @return True if the file was written.
    * @exception Exception
    */
   public boolean writeFile() throws Exception
   {
      return writeFile("Converted");
   }

   /**
    * Saves the current image as a JPEG named Converted.jpg.
    * 
    * @param pName Filename to save the JPEG to.
    * @return True if the file was written.
    * @exception Exception
    */
   public boolean writeFile(String pName) throws Exception
   {
      return cam.saveJPEG(pName);
   }

   /**
    * Resizes the image being displayed, not the camera's configuration.
    * 
    * @param newW New width.
    * @param newH New height.
    */
   @Override
   public void resizeImage(int newW, int newH)
   {
      try
      {
         //resets the image to the original
         image = new ImageIcon(cam.getImage());
         super.resizeImage(newW, newH);
      }
      catch (Exception e)
      {
      }
   }

   /**
    * Returns the current Image.
    * 
    * @return The current Image.
    */
   @Override
   public Image getImage()
   {
      return getBufferedImage();
   }

   /**
    * Returns the current BufferedImage.
    * 
    * @return The current BufferedImage.
    */
   @Override
   public BufferedImage getBufferedImage()
   {
      try
      {
         return cam.getImage();
      }
      catch (Exception e)
      {
         return null;
      }
   }
}
