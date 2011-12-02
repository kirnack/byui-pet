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
   
   LoggingInformation()
   {
      plateNo = new String();
      location = new String();
      time = new String();
   }
   
   LoggingInformation(String plateNoStr, String locationStr, String timeStr)
   {
      plateNo = plateNoStr;
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
      plateNo = plateNoStr;
   }
}
