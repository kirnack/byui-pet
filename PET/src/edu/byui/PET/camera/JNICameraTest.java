/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.camera;

import edu.byui.PET.images.CameraImagePanel;
import edu.byui.PET.images.DataFileImagePanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author kirnack
 */
public class JNICameraTest
{

   /**
    * 
    */
   public static JFrame aJFrame;
   /**
    * 
    */
   public static DataFileImagePanel image;
   /**
    * 
    */
   public static CameraImagePanel image2;
   /**
    * 
    */
   public static JTextField textField;

   /**
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      new JNICameraTest();
   }

   public JNICameraTest()
   {
      try
      {
         testPanel();
      }
      catch (Exception E)
      {
         E.printStackTrace();
      }
   }

   private void testPanel() throws Exception
   {
      image2 = new CameraImagePanel(
              new JNICamera(new PETConfiguration(PETConfiguration.GRAY_SCALE)));

      BorderLayout cSpringLayout = new BorderLayout();

      aJFrame = new JFrame();
      aJFrame.setSize(800, 600);
      aJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      aJFrame.setLayout(cSpringLayout);

      //These lines of code are absolutly nessisary to resize the image properly
      aJFrame.addComponentListener(new ComponentListener()
      {

         public void componentHidden(ComponentEvent e)
         {
         }

         public void componentMoved(ComponentEvent e)
         {
         }

         public void componentShown(ComponentEvent e)
         {
            image2.resizeImage(image2.getWidth(), image2.getHeight());
         }

         public void componentResized(ComponentEvent e)
         {
            image2.resizeImage(image2.getWidth(), image2.getHeight());
         }
      });

      JButton button = new JButton("Capture Image");
      button.setPreferredSize(new Dimension(200, 100));
      button.addActionListener(new ActionListener()
      {

         public void actionPerformed(ActionEvent e)
         {
            try
            {
               image2.capture();
               image2.repaint();
            }
            catch (Exception ex)
            {
               ex.printStackTrace();
            }
         }
      });

      aJFrame.add(button, BorderLayout.PAGE_END);

      aJFrame.getContentPane().add(image2, BorderLayout.CENTER);
      new Thread(new Refresher(image2)).start();
      aJFrame.setVisible(true);
   }

   private class Refresher extends Thread
   {

      CameraImagePanel image;

      Refresher(CameraImagePanel pImg)
      {
         image = pImg;
      }

      @Override
      public void run()
      {
         while(true)
         {
            try
            {
               System.err.println("refreshing");
               image.capture();
               System.err.println("refreshed");
            }
            catch (Exception ex)
            {
               Logger.getLogger(JNICameraTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            try
            {
               Refresher.sleep(1000);
            }
            catch (InterruptedException ex)
            {
               Logger.getLogger(JNICameraTest.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
      }
   }
}
