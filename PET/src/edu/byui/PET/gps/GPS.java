package edu.byui.PET.gps;

class GPS
{
   private long ptr;
   
   public GPS()
   {
      ptr = createGPS();
   }
   
   public byte[] getGPSData()
   {
      return getGPSData(ptr);
   }
   
   private native long createGPS();
   private native byte[] getGPSData(long ptr);
   
}

