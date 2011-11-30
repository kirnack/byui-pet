/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.camera;

/**
 *
 * @author kirnack
 */
public class BaslerA311JNI extends JNICamera
{
   static
   {
      if(System.getProperty("os.name").equals("Mac OS X"))
      {
         System.load(ClassLoader.getSystemResource(
                 "edu/byui/PET/camera/jnilibs/libPETBasler.dylib").getFile());
      }
      else if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
      {
         System.load(ClassLoader.getSystemResource(
                 "edu/byui/PET/camera/jnilibs/libPETBasler.dll").getFile());
      }
      else if (System.getProperty("os.name").equals("Linux"))
      {
         System.exit(1);
      }
   }
   
   BaslerA311JNI(Configuration pCs)
   {
      super(pCs);
   }
   
   private native long createCamera();
   private native byte[] getCameraData(long ptr, long size);
   private native int getXResolution(long ptr);
   private native int getYResolution(long ptr);
}
