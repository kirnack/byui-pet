/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.util;

/**
 *
 * @author Matthew
 */
public class LoggingInformation
{
   String plateNo;
   String location;
   String time;
   
   public LoggingInformation()
   {
      plateNo = new String();
      location = new String();
      time = new String();
   }
   
   public LoggingInformation(String plateNoStr, String locationStr, String timeStr)
   {
      plateNo = plateNoStr.toUpperCase();
      location = locationStr;
      time = timeStr;
   }
   
   public String getPlateNo()
   {
      return(plateNo);
   }
   
   public String getLocation()
   {
      return(location);
   }
   
   public String getTime()
   {
      return(time);
   }
   
   public void setPlateNo(String plateNoStr)
   {
      plateNo = plateNoStr.toUpperCase();
   }
   
   public void setLocation(String locationStr)
   {
      location = locationStr.toUpperCase();
   }
   
   public void setTime(String timeStr)
   {
      time = timeStr.toUpperCase();
   }
}
