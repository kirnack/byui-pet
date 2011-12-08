/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.util;

/**
 *
 * @author Matthew
 * This is the class for the objects that are going to be passed to and from the 
 * logging database.
 */
public class LoggingInformation
{
   String plateNo;  //License plate searching for or writing to the database.
   String location; //GPS coordinates when the license plate was seen.
   String time;     //Time when the license plate was last seen.
   
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
