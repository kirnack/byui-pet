/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.camera;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * A Camera Class that accesses the BaslerA311 camera
 * via JNI.
 * @author kirnack
 */
public class BaslerA311JNI extends PETCamera
{
   /**
    * Loads a dynamic library for the JNI code to work.
    * @param path The path to copy the dynamic library to 
    * @param name The name of the dynamic library
    */   
    static void loadLib(String path, String name)
   {
      try
      {
         
         InputStream in = BaslerA311JNI.class.getResourceAsStream(name);
         File dir = new File(path);
         if (!dir.exists() || dir.isFile())
         {
            dir.mkdirs();
         }
         File fileout = new File(dir.getPath() + "/" + name);
         
         FileOutputStream out = new FileOutputStream(fileout);
         byte[] buf = new byte[100];
         int len = 0;
         while((len = in.read(buf)) >= 0)
         {
            out.write(buf, 0, len);
         }
         out.close();
         System.load(fileout.getAbsolutePath());
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }
   
    /**
     * Loads the JNI dynamic library for the respective  OSs
     */
   static
   {
      if(System.getProperty("os.name").equals("Mac OS X"))
      {
         System.exit(4);
      }
      else if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
      {
         if(System.getProperty("os.arch").equalsIgnoreCase("x86"))
         {
            loadLib(System.getProperty("java.io.tmpdir") + "/.petlibs", "baslera311.dll");
         }
         else
         {
            loadLib(System.getProperty("java.io.tmpdir") + "/.petlibs", "baslera311x64.dll");
         }
      }
      else if (System.getProperty("os.name").equals("Linux"))
      {
         System.exit(1);
      }
   }
   
   /**
    * A long holding the address of the C++ object.
    */
   private long ptr;

   /**
    * Creates a BASLERA311JNI Camera by calling JNI code to create a 
    * CameraBuffer to communicate to the camera.
    * 
    * @param pCs The configuration for the camera.
    */
   public BaslerA311JNI(Configuration pCs)
   {
      super(pCs);
      ptr = createCamera();
   }

   /**
    * Retrieves the width and height of the image, sets the configuration
    * x and y appropriately. Then it gets the pixel data from the BaslerA311JNI.
    */
   @Override
   public boolean retrieveData() throws IOException
   {
      boolean result = false;
      int x = getXResolution(ptr);
      int y = getYResolution(ptr);
      if (setRes(x, y))
      {
         long size = x * y;
         data = getCameraData(ptr, size);
         result = true;
      }
      return result;
   }

   /**
    * 
    * @return The address of the CameraBuffer.
    */
   protected long getPtr()
   {
      return ptr;
   }

   /**
    * Creates a C++ CameraBuffer and then returns the address of it as a long.
    * @return The address of the CameraBuffer.
    */
   private native long createCamera();
   
   /**
    * Gets the current image data from the CameraBuffer.
    * @param ptr Address of the CameraBuffer
    * @param size Size of the byte array to store the data in.
    * @return A byte[] containing the pixel data of the current image;
    */
   private native byte[] getCameraData(long ptr, long size);
   
   /**
    * Returns the width of the current image.
    * @param ptr Address of the CameraBuffer
    * @return The width of the current image.
    */
   private native int getXResolution(long ptr);
   
   /**
    * Returns the height of the current image.
    * @param ptr Address of the CameraBuffer
    * @return The height of the current image.
    */
   private native int getYResolution(long ptr);
}
