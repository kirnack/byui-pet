package edu.byui.PET.camera;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Designed to communicate with a command line program to get data from the
 * hardware camera.
 * 
 * @deprecated Due to issues with interprocess communication not working.
 * @author Bryon Rogers
 */
@Deprecated
public class PETProcCamera extends PETCamera
{

   private Process mProc;
   private BufferedWriter output;
   private BufferedReader cout;
   private BufferedReader cerr;

   /**
    * Creates a  PETProcCamera that runs and communicates with pProc
    * to get data from the camera.
    * 
    * @param pProc Name of program to run
    * @param ImageType Type of image configuration to use.
    * @throws IOException
    */
   public PETProcCamera(String pProc, int ImageType) throws IOException
   {
      super(new PETConfiguration(ImageType));
      mProc = Runtime.getRuntime().exec(pProc);
      output = new BufferedWriter(new OutputStreamWriter(mProc.getOutputStream()));
      cout = new BufferedReader(new InputStreamReader(mProc.getInputStream()));
      cerr = new BufferedReader(new InputStreamReader(mProc.getErrorStream()));
   }

   /**
    * Creates a  PETProcCamera that runs and communicates with pProc
    * to get data from the camera, using a GRAY_SCALE configuration.
    * 
    * @param pProc Name of program to run.
    * @throws IOException
    */
   public PETProcCamera(String pProc) throws IOException
   {
      this(pProc, PETConfiguration.GRAY_SCALE);
   }

   /**
    * Prompts the process to get the next image.
    * 
    * @deprecated Due to hanging during interprocess communication.
    * @return true if successful
    * @throws IOException
    */
   @Deprecated
   public boolean retrieveData() throws IOException
   {
      output.write("1");
      output.newLine();
      output.flush();
      int i = 0;
      try
      {
         mProc.waitFor();
      }
      catch (InterruptedException ex)
      {
         Logger.getLogger(PETProcCamera.class.getName()).log(Level.SEVERE, null, ex);
      }
      //while(!cerr.ready())
      //{
      //   System.err.println(i);
      //   i++;
      //}
      String strX = cerr.readLine();
      String strY = cerr.readLine();
      System.err.println(strX);
      System.err.println(strY);
      int x = Integer.parseInt(strX);
      int y = Integer.parseInt(strY);
      setRes(x, y);
      int size = x * y * config.getBPP() / 8;
      char[] chars = new char[size];
      cout.read(chars, 0, size);
      data = new String(chars).getBytes();
      return true;
   }

   /**
    * Kill the process that is being run.
    * 
    * @return True if successful.
    */
   public boolean killProc()
   {
      try
      {
         output.write("q");
         output.newLine();
         mProc.waitFor();
      }
      catch (Exception e)
      {
         mProc.destroy();
      }
      return true;
   }
}
