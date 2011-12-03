/*
 * PETAPP.java
 */

package edu.byui.PET;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

/**
 * The main class of the application.
 */
public class PETAPP extends SingleFrameApplication {

    /**
     * At startup create and show the main frame of the application.
     */
    @Override protected void startup() {
       File config = new File("." + "/" + "config.xml");
       if (!config.exists() || !config.isFile())
       {
          try
          {
          InputStream in = PETAPP.class.getResourceAsStream("config.xml");
          FileOutputStream out = new FileOutputStream(config);
          byte[] data = new byte [100];
          int len = 0;
          while((len = in.read(data)) > 0)
          {
             out.write(data, 0, len);
          }
          out.close();
          in.close();
          }
          catch(Exception e)
          {
             System.exit(10);
          }
       }
        show(new PETAPPView());
        
    }

    /**
     * This method is to initialize the specified window by injecting resources.
     * Windows shown in our application come fully initialized from the GUI
     * builder, so this additional configuration is not needed.
     * @param root 
     */
    @Override protected void configureWindow(java.awt.Window root) {
    }

    /**
     * A convenient static getter for the application instance.
     * @return the instance of PETAPP
     */
    public static PETAPP getApplication() {
        return Application.getInstance(PETAPP.class);
    }

    /**
     * Main method launching the application.
     * @param args 
     */
    public static void main(String[] args) {
        launch(PETAPP.class, args);
    }
}
