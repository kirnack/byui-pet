package edu.byui.PET.camera;

import java.io.*;

/**
 * PETCamera to read saved of pixel data. Used for initial testing of camera
 * communication.
 * 
 * @author kirnack
 */
public class PETFileCamera extends PETCamera
{

   private InputStream in;

   /**
    * Creates a PETFileCamera and loads pFile into the camera.
    * 
    * @param pFile File to open.
    * @param ImageType Type of configuration to use.
    * @throws IOException
    */
   public PETFileCamera(String pFile, int ImageType) throws IOException
   {
      this(new FileInputStream(pFile), ImageType);
   }

   /**
    * Creates a PETFileCamera and loads the file at the path pFile into the
    * camera, with a GRAY_SCALE configuration.
    * 
    * @param pFile Path to the file to load.
    * @throws IOException
    */
   public PETFileCamera(String pFile) throws IOException
   {
      this(pFile, PETConfiguration.GRAY_SCALE);
   }

   private PETFileCamera(FileInputStream pFile, int ImageType) throws IOException
   {
      super(new PETConfiguration(ImageType));
      in = pFile;
   }

   /**
    * Changes the file loaded in the image.
    * 
    * @param pFileName Path of file to load.
    * @return True if load was successful.
    * @throws IOException
    */
   public boolean changeFile(String pFileName) throws IOException
   {
      return changeFile(new FileInputStream(pFileName));
   }

   /**
    * Changes the file loaded in the image.
    * 
    * @param pIn InputStream to use.
    * @return True if loading was successful.
    * @throws IOException
    */
   public boolean changeFile(InputStream pIn) throws IOException
   {
      image = null;
      data = null;
      in = pIn;
      return true;
   }

   /**
    * Retrieves the data from the loaded file and places it into a
    * BufferedImage.
    * 
    * @return True if conversion was successful.
    * @throws IOException
    */
   public boolean retrieveData() throws IOException
   {
      BufferedInputStream bin = new BufferedInputStream(in);
      byte[] xBytes = new byte[3];
      byte[] yBytes = new byte[3];
      bin.read(xBytes, 0, 3);
      bin.read(yBytes, 0, 3);
      System.err.println(new String(xBytes));
      System.err.println(new String(yBytes));
      int x = Integer.parseInt(new String(xBytes));
      int y = Integer.parseInt(new String(yBytes));
      setRes(x, y);
      int size = x * y * config.getBPP() / 8;
      data = new byte[size];
      bin.read(data, 0, size);
      bin.close();
      return true;
   }
}
