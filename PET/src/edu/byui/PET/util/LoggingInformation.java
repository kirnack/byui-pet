/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.util;

/**
 * This is the class for the objects that are going to be passed to and from the 
 * logging database.
 * 
 * @author Matthew
 */
public class LoggingInformation
{
   String plateNo;  //License plate searching for or writing to the database.
   String location; //GPS coordinates when the license plate was seen.
   String time;     //Time when the license plate was last seen.
   
   /**
    * Creates a new LoggingInformation object.
    */
   public LoggingInformation()
   {
      plateNo = new String();
      location = new String();
      time = new String();
   }
   
   /**
    * Creates a new LoggingInformation object.
    * 
    * @param plateNoStr Plate number
    * @param locationStr Location string
    * @param timeStr Time as a string
    */
   public LoggingInformation(String plateNoStr, String locationStr, String timeStr)
   {
      plateNo = plateNoStr.toUpperCase();
      location = locationStr;
      time = timeStr;
   }
   
   /**
    * Returns the plate number
    * 
    * @return The plate number
    */
   public String getPlateNo()
   {
      return(plateNo);
   }
   
   /**
    * Returns the location string
    * 
    * @return Location string
    */
   public String getLocation()
   {
      return(location);
   }
   
   /**
    * Returns the string of the time.
    * 
    * @return Time as a string
    */
   public String getTime()
   {
      return(time);
   }
   
   /**
    * Sets the plate number.
    * 
    * @param plateNoStr String to set the plate number to.
    */
   public void setPlateNo(String plateNoStr)
   {
      plateNo = plateNoStr.toUpperCase();
   }
   
   /**
    * Sets the location string.
    * 
    * @param locationStr String to set the location string to.
    */
   public void setLocation(String locationStr)
   {
      location = locationStr.toUpperCase();
   }
   
   /**
    * Sets the time string.
    * 
    * @param timeStr String to set the time string to.
    */
   public void setTime(String timeStr)
   {
      time = timeStr.toUpperCase();
   }
}
