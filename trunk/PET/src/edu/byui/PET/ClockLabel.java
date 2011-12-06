package edu.byui.PET;

import java.util.Date;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

 class ClockLabel extends JLabel implements ActionListener {
  public String nowdate;
  public String nowtime;
  
  public void ClockLabel() 
  {
      
  }

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
  public String getTime(){return(nowtime);}
  public String getDate(){return(nowdate);}
}
