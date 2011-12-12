package edu.byui.PET.images;

import edu.byui.PET.camera.Camera;
import edu.byui.PET.camera.PETProcCamera;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.awt.image.*;

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
   
   public CameraImagePanel(Camera pCam)
   {
      cam = pCam;
      try
      {
         cam.captureImage();
         image = new ImageIcon(cam.getImage());
      }
      catch (Exception e)
      {
         
      }
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
      super.paint(getGraphics());
   }

   public void setCamera(Camera pCam)
   {
      cam = pCam;
   }
   
   public Camera getCamera()
   {
      return cam;
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