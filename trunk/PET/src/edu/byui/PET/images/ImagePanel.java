package edu.byui.PET.images;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import java.net.URL;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * A JPanel to display a picture on.
 * @author Bryon Rogers
 **/
@SuppressWarnings("serial")
public class ImagePanel
        extends JPanel
{

   /**
    * Holds the wanted background Image
    **/
   protected ImageIcon image;
   /**
    * Holds the preferred size of the image
    **/
   private Dimension size;
   /**
    * Holds background Location
    **/
   private String backLoc;

   /**
    * Creates a default  ImagePanel and sets up the resize listener.
    */
   public ImagePanel()
   {
      //These lines of code are absolutly nessisary to resize the image properly
      addComponentListener(new ComponentListener()
      {

         public void componentHidden(ComponentEvent e)
         {
         }

         public void componentMoved(ComponentEvent e)
         {
         }

         public void componentShown(ComponentEvent e)
         {
         }

         public void componentResized(ComponentEvent e)
         {
            resizeImage(getWidth(), getHeight());
         }
      });
   }

   /**
    * Creates a new BackgroundPanel
    *
    * @param pURL  URL of the file to load.
    */
   public ImagePanel(URL pURL)
   {
      this();
      try
      {
         image = new ImageIcon(pURL);
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   /**
    * Overrides paints
    * @param g  Graphics to paint on.
    */
   @Override
   public void paint(Graphics g)
   {
      super.paint(g);
   }

   /**
    * Overrides the paintComponent to display the background Image
    *
    * @param g  Graphics to paint on.
    */
   @Override
   protected void paintComponent(Graphics g)
   {
      if(image != null)
      {
         super.paintComponent(g);
         //System.err.println("Paniting");
         g.drawImage(image.getImage(), 0, 0, null);
      }
   }

   /**
    * Changes the image icon to the specified address in the config file
    **/
   public void getImageLoc()
   {
      if(image != null)
      {
         size = getSize();
         /**
          * resizes the image to the specified screen height and width
          **/
         Image img = image.getImage();
         Image newImg = img.getScaledInstance(size.width, size.height, java.awt.Image.SCALE_SMOOTH);
         image = new ImageIcon(newImg);
      }
   }

   /**
    * Loads a pImg into the  ImagePanel.
    * 
    * @param pImg  ImageIcon to load.
    */
   public void setImageIcon(ImageIcon pImg)
   {
      if(pImg.getImage() != null)
      {
         image = pImg;
         resizeImage(getWidth(), getHeight());
         paint(getGraphics());
      }
      else
      {
         image = new ImageIcon();
         getGraphics().clearRect(0, 0, getWidth(), getHeight());
      }
   }

   /**
    * Loads a image located at file into the  ImagePanel.
    * 
    * @param file Path to image to load.
    */
   public void setImageIcon(File file)
   {
      try
      {
         setImageIcon(new ImageIcon(ImageIO.read(file)));
      }
      catch(Exception ex)
      {
         ex.printStackTrace();
      }
   }
   
   /**
    * Resizes the image being displayed, not the camera's configuration.
    * 
    * @param newW New width.
    * @param newH New height.
    */
   public void resizeImage(int newW, int newH)
   {
      if(image != null)
      {
         int w = image.getIconWidth();
         int h = image.getIconHeight();
         Image oldImage = image.getImage();
         BufferedImage img = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_RGB);
         Graphics2D g = img.createGraphics();
         g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         g.drawImage(oldImage, 0, 0, newW, newH, 0, 0, w, h, null);
         g.dispose();
         image.setImage(img);
      }
   }
   
   /**
    * Returns the current image as a  BufferedImage.
    * 
    * @return A  BufferedImage of the current image.
    */
   public Image getImage()
   {
      return getBufferedImage();
   }

   /**
    * Converts an  ImageIcon to a  BufferedImage.
    * 
    * @return A  BufferedImage of the current image.
    */
   public BufferedImage converToBuffereImage()
   {
      BufferedImage buff;
      int w = image.getIconWidth();
         int h = image.getIconHeight();
         Image oldImage = image.getImage();
         buff = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
         Graphics2D g = buff.createGraphics();
         g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         g.drawImage(oldImage, 0, 0, w, h, 0, 0, w, h, null);
         g.dispose();
      return  buff;
   }
   
   /**
    * Returns the current  BufferedImage.
    * 
    * @return The current  BufferedImage.
    */
   public BufferedImage getBufferedImage()
   {
         return converToBuffereImage();
   }
}