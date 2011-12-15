/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.camera;

import edu.byui.PET.ClockLabel;
import edu.byui.PET.images.CameraImagePanel;
import edu.byui.PET.images.DataFileImagePanel;
import edu.byui.PET.images.Refresher;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Tests the JNICamera or BaslerA311JNI
 * 
 * @author Bryon Rogers
 */
public class JNICameraTest
{

   /**
    *
    */
   private static JFrame aJFrame;
   /**
    *
    */
   private static DataFileImagePanel image;
   /**
    *
    */
   private static CameraImagePanel image2;
   /**
    *
    */
   private static JTextField textField;
   /**
    * 
    */
   private static ClockLabel clock;
   /**
    * 
    */
   private static Refresher refresh;

   /**
    * Creates the test
    * @param args the command line arguments
    */
   public static void main(String[] args)
   {
      new JNICameraTest();
   }

   /**
    * Creates a @see JNICameraTest object to test the camera.
    */
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
              new BaslerA311JNI(new PETConfiguration(PETConfiguration.GRAY_SCALE)));

      clock = new ClockLabel();

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
               String name = clock.getTime().replace(":", ",");
               System.err.println(name);
               image2.writeFile(name);
            }
            catch (Exception ex)
            {
               ex.printStackTrace();
            }
         }
      });
      
      refresh = new Refresher(image2);

      aJFrame.add(button, BorderLayout.PAGE_END);
      aJFrame.add(clock, BorderLayout.NORTH);
      aJFrame.add(image2, BorderLayout.CENTER);
      new Thread(refresh).start();
      aJFrame.setVisible(true);
      Timer t = new Timer(1000, clock);
      t.start();
   }
}
