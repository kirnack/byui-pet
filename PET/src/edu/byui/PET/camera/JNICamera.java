/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.camera;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author kirnack
 */
public class JNICamera extends PETCamera
{
   private static void copy(File src, File dst) throws IOException
   {
    InputStream in = new FileInputStream(src);
    OutputStream out = new FileOutputStream(dst);

    // Transfer bytes from in to out
    byte[] buf = new byte[1024];
    int len;
    while ((len = in.read(buf)) > 0) {
        out.write(buf, 0, len);
    }
    in.close();
    out.close();
   }
   
   private static void verifyFolder()
   {
      File dir = new File(System.getProperty("user.home")+"/.petdata");
      File packedDir = new File(ClassLoader.getSystemResource(
              "edu/byui/PET/resources/pixelDataFiles").getFile());
      
      if (!dir.exists() || dir.isFile())
      {
         dir.mkdir();
      }
      System.err.println("Dir exists.\nChecking files.");
      for(File file : packedDir.listFiles())
      {
         File destFile = new File(dir.getAbsolutePath() + "/" + file.getName());
         if(file.isFile())
            if ((!destFile.exists() || !destFile.isFile()))
            {
               try
               {
                  copy(file, destFile);
               }
               catch(Exception ex)
               {
                  ex.printStackTrace();
               }
            }
      }
   }
   
   static
   {
      System.err.println("Setting up the pic data folder");
      verifyFolder();
      if(System.getProperty("os.name").equals("Mac OS X"))
      {
         System.load(ClassLoader.getSystemResource(
                 "edu/byui/PET/camera/jnilibs/libJNICamera.dylib").getFile());
      }
      else if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
      {
         System.load(ClassLoader.getSystemResource(
                 "edu/byui/PET/camera/jnilibs/JNICamera.dll").getFile());
      }
      else if (System.getProperty("os.name").equals("Linux"))
      {
         System.exit(1);
      }
   }

   private long ptr;

   public JNICamera(Configuration pCs)
   {
      super(pCs);
      ptr = createCamera();
   }

   /*
    * 
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

   protected long getPtr()
   {
      return ptr;
   }

   private native long createCamera();
   private native byte[] getCameraData(long ptr, long size);
   private native int getXResolution(long ptr);
   private native int getYResolution(long ptr);
}
