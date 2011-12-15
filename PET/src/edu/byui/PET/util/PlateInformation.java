/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.util;

/**
 * This is the class for the objects containing all of the information on a given
 * license plate
 * 
 * @author Matthew
 */
public class PlateInformation
{
   String plateNo; //License number
   String state;   //State of license plate
   String permit;  //The permit attached to the license plate
   String make;    //The make of the car
   String model;   //The model of the car
   String color;   //The color of the car
   //The total number of violations this car has recieved, but it does not take 
   String numViolations; //into account the different types of violations
   
   /**
    * Creates a new PalteInformation object.
    */
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
   
   /**
    * Creates a new PalteInformation object.
    * 
    * @param plateStr Plate number
    * @param stateStr State of registration
    * @param permitStr Permit type
    * @param makeStr Make
    * @param modelStr Model
    * @param colorStr Color
    * @param numViolationsStr Number of violations as a string.
    */
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
   
   /**
    * Gets the plate number.
    * 
    * @return The plate number.
    */
   public String getPlateNo()
   {
      return(plateNo);
   }
   
   /**
    * Gets the state of registration.
    * 
    * @return The state of registration of the car
    */
   public String getState()
   {
      return(state);
   }
   
   /**
    * Gets the permit type.
    * 
    * @return The permit type
    */
   public String getPermit()
   {
      return(permit);
   }
   
   /**
    * Gets the make of the car.
    * 
    * @return The make of the car.
    */
   public String getMake()
   {
      return(make);
   }
   
   /**
    * Gets the model of the car.
    * 
    * @return The model of the car.
    */
   public String getModel()
   {
      return(model);
   }
   
   /**
    * Get the cars color
    * 
    * @return The color of the car.
    */
   public String getColor()
   {
      return(color);
   }
   
   /**
    * Get the number of violations.
    * 
    * @return Number of violations in a string.
    */
   public String getNumViolations()
   {
      return(numViolations);
   }
   
   /**
    * Sets the plate string.
    * 
    * @param plateNoStr String for the plate
    */
   public void setPlate(String plateNoStr)
   {
      plateNo = plateNoStr;
   }
   
   /**
    * Sets the state.
    * 
    * @param stateStr String for the state
    */
   public void setState(String stateStr)
   {
      state = stateStr;
   }
   
   /**
    * Set the permit type.
    * @param permitStr String for the permit type.
    */
   public void setPermit(String permitStr)
   {
      permit = permitStr;
   }
   
   /**
    * Sets the make
    * 
    * @param makeStr String for the make
    */
   public void setMake(String makeStr)
   {
      make = makeStr;
   }
   
   /**
    * Sets the model.
    * 
    * @param modelStr String for the model
    */
   public void setModel(String modelStr)
   {
      model = modelStr;
   }
   
   /**
    * Sets the color string.
    * @param colorStr String for the color
    */
   public void setColor(String colorStr)
   {
      color = colorStr;
   }
   
   /**
    * Sets the number of violation.
    * @param numViolationsStr String for the number of violations.
    */
   public void setNumViolations(String numViolationsStr)
   {
      numViolations = numViolationsStr;
   }
   
}

