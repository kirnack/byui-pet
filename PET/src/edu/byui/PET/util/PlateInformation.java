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
   
   public PlateInformation()
   {
      plateNo = new String();
      plateNo = null;
      state = new String();
      state = null;
      permit = new String();
      permit = null;
      make = new String();
      make = null;
      model = new String();
      model = null;
      color = new String();
      color = null;
      numViolations = new String();
      numViolations = null;
   }
   
   public PlateInformation(String plateStr, String stateStr, String permitStr,
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

