/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.images;

import edu.byui.PET.camera.JNICameraTest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brogers3
 */
public class Refresher extends Thread
{
   CameraImagePanel image;
   boolean paused;
   boolean die;
   long delay;
   
   public Refresher(CameraImagePanel pImg)
   {
      image = pImg;
      die = false;
      paused = false;
      delay = 100;
   }
   
   public void play()
   {
      paused = false;
   }
   
   public void pause()
   {
      paused = true;
   }
   
   public void kill()
   {
      die = true;
   }
   
   public void resurect()
   {
      die = false;
   }
   
   public void setDelay(long pDelay)
   {
      delay = pDelay;
   }
   
   @Override
   public void run()
   {
      while(!die)
      {
         try
         {
            Refresher.sleep(delay);
         }
         catch (InterruptedException ex)
         {
            Logger.getLogger(JNICameraTest.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
         }
         if(!paused)
         {
            try
            {
               image.capture();
               image.repaint();
            }
            catch (Exception ex)
            {
               Logger.getLogger(JNICameraTest.class.getName()).log(Level.SEVERE, null, ex);
               ex.printStackTrace();
            }
         }
      }
   }
}
