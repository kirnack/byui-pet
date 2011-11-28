package edu.byui.PET.camera;

import java.io.*;

/**
 * 
 * @author kirnack
 */
public class PETFileCamera extends PETCamera
{

   private InputStream in;

   /**
    * 
    * @param pFile
    * @param ImageType
    * @throws IOException
    */
   public PETFileCamera(String pFile, int ImageType) throws IOException
   {
      this(new FileInputStream(pFile), ImageType);
   }

   /**
    * 
    * @param pFile
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
    * 
    * @param pFileName
    * @return
    * @throws IOException
    */
   public boolean changeFile(String pFileName) throws IOException
   {
      return changeFile(new FileInputStream(pFileName));
   }

   /**
    * 
    * @param pIn
    * @return
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
    * 
    * @return
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
