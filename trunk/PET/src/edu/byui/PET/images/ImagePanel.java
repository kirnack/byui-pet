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
 *
 *
 **/
@SuppressWarnings("serial")
public class ImagePanel
        extends JPanel
{

   /**
    * Holds the Wanted background Image
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
    *
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
    * @param pURL
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

   @Override
   public void paint(Graphics g)
   {
      super.paint(g);
   }

   /**
    * Overrides the paintComponent to display the background Image
    *
    * @param g
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
    * changes the image icon to the specificed address in the config file
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

   public void setImageIcon(ImageIcon pImg)
   {
      if(pImg != null)
      {
         image = pImg;
         resizeImage(getWidth(), getHeight());
         paint(getGraphics());
      }
   }

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
    *
    * @param newW
    * @param newH
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
    * 
    * @return
    */
   public Image getImage()
   {
      return getBufferedImage();
   }

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
    * 
    * @return
    */
   public BufferedImage getBufferedImage()
   {
         return converToBuffereImage();
   }
}