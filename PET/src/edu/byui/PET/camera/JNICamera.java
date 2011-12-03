/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.camera;

import edu.byui.PET.resources.pixelDataFiles.Pix;
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
      
      if(dir.exists() && !dir.isFile())
      {
         System.err.println("Dir exists.\nChecking files.");
      try
      {
      InputStream in = Pix.class.getResourceAsStream("test6.data");
      FileOutputStream out = new FileOutputStream(dir.toString() + "/test6.data");
         byte[] buf = new byte[100];
         int len = 0;
         while((len = in.read(buf)) >= 0)
         {
            out.write(buf, 0, len);
         }
         out.close();
         in = Pix.class .getResourceAsStream("test7.data");
         out = new FileOutputStream(dir.toString() + "/test7.data");
         buf = new byte[100];
         len = 0;
         while((len = in.read(buf)) >= 0)
         {
            out.write(buf, 0, len);
         }
         out.close();
         in = Pix.class .getResourceAsStream("test8.data");
         out = new FileOutputStream(dir.toString() + "/test8.data");
         buf = new byte[100];
         len = 0;
         while((len = in.read(buf)) >= 0)
         {
            out.write(buf, 0, len);
         }
         out.close();
      }
      catch (Exception e)
      {
         
      }
      }
   }
   
   static void loadLib(String path, String name)
   {
      try
      {
         
         InputStream in = JNICamera.class.getResourceAsStream(name);
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
   
   static
   {
      
      System.err.println("Setting up the pic data folder");
      try
      {
         verifyFolder();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
              
      if(System.getProperty("os.name").equals("Mac OS X"))
      {
         loadLib( System.getProperty("java.io.tmpdir") + "/.petlibs", "libJNICamera.dylib");
      }
      else if (System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
      {
         loadLib( System.getProperty("java.io.tmpdir") + "/.petlibs",  "jnilibtest.lib");
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
