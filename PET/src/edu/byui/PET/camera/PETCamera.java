package edu.byui.PET.camera;

import java.io.*;
import java.awt.image.*;
import java.awt.*;

/**
 * An abstract camera for the PET project, that will take the pixel data
 * and create a BufferedImage from it. It calls has a private retrieveData()
 * method to actually get the camera data from the hardware camera.
 * 
 * @author kirnack
 */
public abstract class PETCamera extends Camera
{

   /**
    * Creates a PETCamera with pCS as it's configuration.
    * 
    * @param pCS The configuration for the Camera.
    */
   public PETCamera(Configuration pCS)
   {
      super.config = pCS;
   }

   /**
    * Creates a PETCamera
    * 
    * @param pCS The Configuration for the camera.
    * @param pX  The width (a.k.a. X)
    * @param pY  The height (a.k.a. Y)
    */
   public PETCamera(Configuration pCS, int pX, int pY)
   {
      super.config = pCS;
      super.config.setXRes(pX);
      super.config.setYRes(pY);
   }

   /**
    * Changes the resolution of the Camera to pX x xY.
    * 
    * @param pX  The width (a.k.a. X)
    * @param pY  The height (a.k.a. Y)
    * @return True if the resolution was changed.
    */
   public boolean setRes(int pX, int pY)
   {
      if (config != null)
      {
         super.config.setXRes(pX);
         super.config.setYRes(pY);
         return true;
      }
      else
      {
         return false;
      }
   }

   /**
    * Retrieves data from the underling hardware camera.
    * 
    * @return True if the data was retrieved.
    * @throws IOException
    */
   public abstract boolean retrieveData() throws IOException;

   /**
    * Creates a BufferedImage from a new image from the hardware camera.
    * 
    * @return True if it was successful in capturing the new image.
    * @throws IOException
    */
   public boolean captureImage() throws IOException
   {
      retrieveData();
      if (data != null)
      {
         int x = super.config.getXRes();
         int y = super.config.getYRes();
         int bitPerPixel = super.config.getBPP();
         int[] nBits = super.config.getNBits();
         DataBuffer dbuf = new DataBufferByte(data, x * y * (bitPerPixel / 8));
         int numBanks = dbuf.getNumBanks();
         ColorModel colorModel = new ComponentColorModel(super.config.getColorSpace(), nBits, false, false,
                 Transparency.OPAQUE, DataBuffer.TYPE_BYTE);
         SampleModel sampleModel = colorModel.createCompatibleSampleModel(x, y);
         WritableRaster raster = Raster.createWritableRaster(sampleModel, dbuf, null);

         image = new BufferedImage(colorModel, raster, false, null);

         return image != null;
      }
      return false;
   }
}
