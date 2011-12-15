package edu.byui.PET;

import java.util.Date;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

/**
 * A JLabel that will display the current date and time and refresh itself.
 * 
 * @author Matt Jones
 */
public class ClockLabel extends JLabel implements ActionListener {
   /**
    * 
    */
   private String nowdate;
   /**
    * 
    */
   private String nowtime;

  /**
   * Creates a new ClockLabel
   */
  public void ClockLabel()
  {

  }

  /**
   * Refreshes the data shown in the label.
   * 
   * @param ae ActionEvent that happened.
   */
  public void actionPerformed(ActionEvent ae)
  {
     Format time = new  SimpleDateFormat("h:mm:ss a");
     Format today = new SimpleDateFormat("MM/dd/yyyy");
     Format timedate = new SimpleDateFormat("h:mm:ss a     MM/dd/yyyy");
     Date d = new Date();
    setText(timedate.format(d));
    nowdate = today.format(d);
    nowtime = time.format(d);
    //System.err.println("timer action fired");
  }
  /**
   * Get the current time as a String.
   * @return String of the current time.
   */
  public String getTime(){return(nowtime);}
  /**
   * Get the current date as a String.
   * @return String of the current date.
   */
  public String getDate(){return(nowdate);}
}
