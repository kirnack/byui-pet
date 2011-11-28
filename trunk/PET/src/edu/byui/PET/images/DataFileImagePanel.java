package edu.byui.PET.images;

import javax.swing.ImageIcon;
import java.awt.image.*;
import java.awt.Image;
import edu.byui.PET.camera.*;

/**
 * 
 * @author kirnack
 */
@SuppressWarnings("serial")
public class DataFileImagePanel extends ImagePanel
{

   PETFileCamera cam;

   /**
    * 
    * @throws Exception
    */
   public DataFileImagePanel() throws Exception
   {
      this("test8.data", PETConfiguration.GRAY_SCALE);
   }

   /**
    * 
    * @param pFile
    * @param colorType
    * @throws Exception
    */
   public DataFileImagePanel(String pFile, int colorType) throws Exception
   {

      cam = new PETFileCamera(pFile, colorType);
      cam.captureImage();
      image = new ImageIcon(cam.getImage());
   }

   /**
    * 
    * @param pFile
    * @return
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
    * 
    * @return
    * @throws Exception
    */
   public boolean writeFile() throws Exception
   {
      return writeFile("Converted");
   }

   /**
    * 
    * @param pName
    * @return
    * @throws Exception
    */
   public boolean writeFile(String pName) throws Exception
   {
      return cam.saveJPEG(pName);
   }

   /**
    * 
    * @param newW
    * @param newH
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
    * 
    * @return
    */
   public Image getImage()
   {
      return getBufferedImage();
   }

   /**
    * 
    * @return
    */
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
