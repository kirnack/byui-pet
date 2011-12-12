package edu.byui.PET.camera;

import java.io.*;
import java.awt.image.*;
import java.awt.*;

/**
 * 
 * @author kirnack
 */
public abstract class PETCamera extends Camera
{

   /**
    * 
    * @param pCS
    */
   public PETCamera(Configuration pCS)
   {
      super.config = pCS;
   }

   /**
    * 
    * @param pCS
    * @param pX
    * @param pY
    */
   public PETCamera(Configuration pCS, int pX, int pY)
   {
      super.config = pCS;
      super.config.setXRes(pX);
      super.config.setYRes(pY);
   }

   /**
    * 
    * @param pX
    * @param pY
    * @return
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
    * 
    * @return
    * @throws IOException
    */
   public abstract boolean retrieveData() throws IOException;

   /**
    * 
    * @return
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
