/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.images;

import edu.byui.PET.camera.JNICameraTest;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A thread to refresh a CameraImagePanel to provide a semi-live feed.
 * 
 * @author Bryon Rogers
 */
public class Refresher extends Thread
{
   CameraImagePanel image;
   boolean paused;
   boolean die;
   long delay;
   
   /**
    * Creates a Refresher to refresh pImg at regular intervals.
    * @param pImg  CameraImagePanel to refresh.
    */
   public Refresher(CameraImagePanel pImg)
   {
      image = pImg;
      die = false;
      paused = false;
      delay = 100;
   }
   
   /**
    * Allows the  CameraImagePanel to recapture after a certain delay.
    */
   public void play()
   {
      paused = false;
   }
   
   /**
    * Pauses the  CameraImagePanel recapture process.
    */
   public void pause()
   {
      paused = true;
   }
   
   /**
    * Kills the Refresher.
    */
   public void kill()
   {
      die = true;
   }
   
   /**
    * Allows the Refresher to be restarted in a new thread after a  kill()
    */
   public void resurect()
   {
      die = false;
   }
   
   /**
    * Sets the Refresher's delay.
    * 
    * @param pDelay The number of milliseconds to delay the recapture.
    */
   public void setDelay(long pDelay)
   {
      delay = pDelay;
   }
   
   /**
    * While Refresher is not dead keep looping. While in the loop if Refresher
    * is not paused call  capture() on the  CameraImagePanel
    */
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
