/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.util;

/**
 *
 * @author Matthew
 */
public class PlateInformation
{
   String plateNo;
   String state;
   String permit;
   String make;
   String model;
   String color; 
   String numViolations;
   
   PlateInformation()
   {
      plateNo = new String();
      state = new String();
      permit = new String();
      make = new String();
      model = new String();
      color = new String();
      numViolations = new String();
   }
   
   PlateInformation(String plateStr, String stateStr, String permitStr,
           String makeStr, String modelStr, String colorStr, String numViolationsStr)
   {
      plateNo = plateStr;
      state = stateStr;
      permit = permitStr;
      make = makeStr;
      model = modelStr;
      color = colorStr;
      numViolations = numViolationsStr;
   }
   
   public String getPlateNo()
   {
      return(plateNo);
   }
   
   public String getState()
   {
      return(state);
   }
   
   public String getPermit()
   {
      return(permit);
   }
   
   public String getMake()
   {
      return(make);
   }
   
   public String getModel()
   {
      return(model);
   }
   
   public String getColor()
   {
      return(color);
   }
   
   public String getNumViolations()
   {
      return(numViolations);
   }
   
   public void setPlate(String plateNoStr)
   {
      plateNo = plateNoStr;
   }
   
   public void setState(String stateStr)
   {
      state = stateStr;
   }
   
   public void setPermit(String permitStr)
   {
      permit = permitStr;
   }
   
   public void setMake(String makeStr)
   {
      make = makeStr;
   }
   
   public void setModel(String modelStr)
   {
      model = modelStr;
   }
   
   public void setColor(String colorStr)
   {
      color = colorStr;
   }
   
   public void setNumViolations(String numViolationsStr)
   {
      numViolations = numViolationsStr;
   }
   
}

