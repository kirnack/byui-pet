package edu.byui.PET.gps;

import edu.byui.PET.camera.JNICamera;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

class GPS
{
   private long ptr;

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
      if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
      {
         //try
         //{
           // System.load(GPS.class.getResource("FinalGPSVcpp.dll").getFile());
         //}
         //catch(Exception e)
         //{
            loadLib(System.getProperty("java.io.tmpdir") + "/.petlibs", "FinalGPSVcpp.dll");
         //}
      }

   }

   public GPS()
   {
      ptr = createGPS();
   }

   public byte[] getGPSData()
   {
      return getGPSData(ptr);
   }

   public String getGPSString()
   {
      return new String(getGPSData(ptr));
   }

   private native long createGPS();
   private native byte[] getGPSData(long ptr);

}

