package edu.byui.PET.images;

import edu.byui.PET.camera.Camera;
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
public class CameraImagePanel extends ImagePanel
{

   private Camera cam;

   /**
    * 
    * @param pProc
    * @param colorType
    * @throws Exception
    */
   public CameraImagePanel(String pProc, int colorType) throws Exception
   {
      this(new PETProcCamera(pProc, colorType));
      
   }
   
   public CameraImagePanel(Camera pCam)  throws Exception
   {
      cam = pCam;
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
         Logger.getLogger(CameraImagePanel.class.getName()).
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
      repaint();
   }

   /**
    * 
    * @return
    * @throws Exception
    */
   @Override
   public BufferedImage getBufferedImage()
   {
      try
      {
         return cam.getImage();
      }
      catch(Exception e)
      {
         return null;
      }
   }
}