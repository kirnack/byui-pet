package edu.byui.PET;

import java.util.Date;
import java.awt.event.*;
import javax.swing.*;
import java.text.*;

 class ClockLabel extends JLabel implements ActionListener {
  public void ClockLabel() 
  {
      
  }

  public void actionPerformed(ActionEvent ae)
  {
     Format f = new  SimpleDateFormat("h:mm:ss a");
     Date d = new Date();
    setText(f.format(d));
    //System.err.println("timer action fired");
  }
}