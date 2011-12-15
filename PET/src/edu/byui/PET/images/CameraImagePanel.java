package edu.byui.PET.images;

import edu.byui.PET.camera.Camera;
import edu.byui.PET.camera.PETProcCamera;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import java.awt.image.*;

/**
 * An ImagePanel that has a Camera containing the image to display.
 * @author Bryon Rogers
 */
@SuppressWarnings("serial")
public class CameraImagePanel extends ImagePanel
{

   private Camera cam;

   /**
    * Creates a  CameraImagePanel with a  PETProcCamera running pProc with
    * a configuration of colorType
    * 
    * @deprecated Due to PETProcCamera's instability.
    * @param pProc Process for PETProcCamera to run.
    * @param colorType Configuration type of PETProcCamera.
    * @throws Exception
    */
   @Deprecated
   public CameraImagePanel(String pProc, int colorType) throws Exception
   {
      this(new PETProcCamera(pProc, colorType));
      
   }
   
   /**
    * Creates a  CameraImagePanel with pCam as it's camera.
    * 
    * @param pCam The  CameraImagePanels  Camera.
    */
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
    * Saves the current image as a JPEG named Converted.jpg.
    * 
    * @return True if the file was written.
    */
   public boolean writeFile()
   {
      return writeFile("Converted");
   }

   /**
    * Saves the current image as a JPEG.
    * 
    * @param pName Name of the JPEG to be written.
    * @return True if write was successful.
    */
   public boolean writeFile(String pName)
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
      }
      catch (Exception ex)
      {
         Logger.getLogger(CameraImagePanel.class.getName()).
                 log(Level.SEVERE, null, ex);
      }
      super.resizeImage(newW, newH);
   }

   /**
    * Captures the next image from the  Camera.
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

   /**
    * Change the CameraImagePanel's camera to pCam.
    * 
    * @param pCam New  Camera for the  CameraImagePanel.
    */
   public void setCamera(Camera pCam)
   {
      cam = pCam;
   }
   
   /**
    * Returns the CameraImagePanel's  Camera.
    * @return The current  Camera.
    */
   public Camera getCamera()
   {
      return cam;
   }
   
   /**
    * Returns the  BufferedImage that the  Camera holds.
    * @return Current  BufferedImage.
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