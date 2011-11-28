package edu.byui.PET.images;

import edu.byui.PET.camera.PETProcCamera;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.awt.image.*;
import java.awt.Image;

/**
 * 
 * @author kirnack
 */
@SuppressWarnings("serial")
public class DataProcImagePanel extends ImagePanel
{

   private PETProcCamera cam;

   /**
    * 
    * @param pProc
    * @param colorType
    * @throws Exception
    */
   public DataProcImagePanel(String pProc, int colorType) throws Exception
   {
      cam = new PETProcCamera(pProc, colorType);
      cam.captureImage();
      image = new ImageIcon(cam.getImage());
   }

   /**
    * 
    * @return
    */
   public boolean writeFile()
   {
      return writeFile("Converted");
   }

   /**
    * 
    * @param pName
    * @return
    */
   public boolean writeFile(String pName)
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
      }
      catch (Exception ex)
      {
         Logger.getLogger(DataProcImagePanel.class.getName()).
                 log(Level.SEVERE, null, ex);
      }
      super.resizeImage(newW, newH);
   }

   /**
    * 
    * @throws Exception
    */
   public void capture() throws Exception
   {
      cam.captureImage();
      int w = image.getIconWidth();
      int h = image.getIconHeight();
      resizeImage(w, h);
   }

   /**
    * 
    * @return
    * @throws Exception
    */
   public Image getImage() throws Exception
   {
      return getBufferedImage();
   }

   /**
    * 
    * @return
    * @throws Exception
    */
   public BufferedImage getBufferedImage() throws Exception
   {
      return cam.getImage();
   }
}