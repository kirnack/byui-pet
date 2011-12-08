package edu.byui.PET.gps;

import edu.byui.PET.camera.JNICamera;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class GPS
{
   private long ptr;

   static void loadLib(String path, String name)
   {
      try
      {

         InputStream in = GPS.class.getResourceAsStream(name);
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
      String buffer = new String(getGPSData(ptr));
      //new String(getGPSData(ptr));

      String deg = " Deg ";
      String min = " Min ";
      String space = " ";
      String justLocation;
      //GPS myGPS = new GPS();
      //buffer = myGPS.getGPSString();
      justLocation = buffer.charAt(16) + buffer.charAt(17) + deg  + space +
      buffer.charAt(18) +  buffer.charAt(19) + buffer.charAt(20) +
      buffer.charAt(21) + buffer.charAt(22) + buffer.charAt(23)
      + buffer.charAt(24) + min + buffer.charAt(26) + space + buffer.charAt(28)
      + buffer.charAt(29) +  buffer.charAt(30) + deg + space + buffer.charAt(31)
      + buffer.charAt(32) + buffer.charAt(33) + buffer.charAt(34)
      + buffer.charAt(35) + buffer.charAt(36) + buffer.charAt(37)+ min +
      buffer.charAt(39);
      
      // try returning buffer

      return buffer;

   }

   private native long createGPS();
   private native byte[] getGPSData(long ptr);

}

