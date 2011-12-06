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
 *
 * @author kirnack
 */
public class BaslerA311JNI extends PETCamera
{
   
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
   
   private long ptr;

BaslerA311JNI(Configuration pCs)
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
