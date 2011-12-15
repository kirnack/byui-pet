package edu.byui.PET.gps;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * JNI Class to talk to the GPS
 * @author Bryon Rogers
 */
public class GPS
{
   /**
    * Long containing the address of the underlying c++ GPS object.
    */
   private long ptr;
   /**
    * True if the JNI code was loaded.
    */
   private static boolean loaded;
   
   /**
    * Moves to a temp folder and loads a JNI library
    * 
    * @param path Path of temp folder.
    * @param name Name of JNI lib to load.
    */
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
         loaded = true;
      }
      catch (Exception e)
      {
   //      e.printStackTrace();
         loaded = false;
      }
   }

   /**
    * Loads the appropriate JNI lib based on OS. Currently only WIN32 supported.
    */
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
         if(System.getProperty("os.arch").equalsIgnoreCase("x86"))
         {
            loadLib(System.getProperty("java.io.tmpdir") + "/.petlibs", "FinalGPSVcpp.dll");
         }
         else
         {
            loaded = false;
         }
         //}
      }

   }

   /**
    * Creates a GPS object and to load from JNI code.
    */
   public GPS()
   {
      if(loaded)
      {
         ptr = createGPS();
      }
   }

   /**
    * Gets the current GPS data. If GPS is not loaded the will return "No data."
    * 
    * @return The bytes of the GPS string.
    */
   public byte[] getGPSData()
   {
      if (loaded)
      {
         return getGPSData(ptr);
      }
      else
      {
         return ("No data.".getBytes());
      }
   }

   /**
    * Takes the bytes from getGPSData() and creates a String from it.
    * @return Returns a string of the GPS data.
    */
   public String getGPSString()
   {
      String buffer = new String(getGPSData());
      //new String(getGPSData(ptr));

      if(loaded)
      {
      String deg = "?";
      String min = "?";
      String space = " ";
      String justLocation;
      //GPS myGPS = new GPS();
      //buffer = myGPS.getGPSString();
      justLocation = buffer.charAt(16) + "" + buffer.charAt(17) + deg  + space +
      buffer.charAt(18) +  buffer.charAt(19) + buffer.charAt(20) +
      buffer.charAt(21) + buffer.charAt(22) + buffer.charAt(23)
      + buffer.charAt(24) + min + buffer.charAt(26) + space + buffer.charAt(28)
      + buffer.charAt(29) +  buffer.charAt(30) + deg + space + buffer.charAt(31)
      + buffer.charAt(32) + buffer.charAt(33) + buffer.charAt(34)
      + buffer.charAt(35) + buffer.charAt(36) + buffer.charAt(37)+ min +
      buffer.charAt(39);
      
      // try returning buffer

      return justLocation;
      }
      return buffer;
   }

   /**
    * JNI GPS creation function.
    * @return Address of the C++ JNI GPS object.
    */
   private native long createGPS();
   
   /**
    * Retrieves a byte[] of C++ GPS data.
    * 
    * @param ptr Address of the C++ GPS object.
    * @return A byte[] of C++ GPS data.
    */
   private native byte[] getGPSData(long ptr);

}

