/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.byui.PET.h2_db;

import edu.byui.PET.util.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ashcraft
 */




public class H2_DB_Test {
    

    public H2_DB_Test()
    {
        try
        {
           Class.forName("org.h2.Driver");

        }
        catch (ClassNotFoundException ex)
        {
           
           System.exit(-1);
        }
       Connection connection = null;
       try {
          connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb;MODE=MySQL;IGNORECASE=TRUE");

          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          // Send SQL Commands
         /* statement.executeUpdate("DROP TABLE IF EXISTS permits");
          statement.executeUpdate("CREATE TABLE permits (plate VARCHAR, state VARCHAR,"
                  + " permit VARCHAR, make VARCHAR, model VARCHAR, color VARCHAR, numViolations VARCHAR)");
          statement.executeUpdate("INSERT INTO permits VALUES('1M12345', 'IDAHO',"
                  + " 'N', 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('IMB2Z78', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M8Z72B', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("CREATE INDEX IDX_PLATE ON permits(plate)");
          statement.executeUpdate("DROP TABLE IF EXISTS logging");
          statement.executeUpdate("CREATE TABLE logging (plate VARCHAR, gps VARCHAR, time VARCHAR)");
          statement.executeUpdate("CREATE INDEX IDX_PLATE ON logging(plate)");
          statement.executeUpdate("INSERT INTO logging VALUES('1M12345', '157.201, 83.45', '14:35:35')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M56709', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2F28901', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78285', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('5EGG864', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M82230', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('5YKG604', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BCR888', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1111111', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");*/
          
           }
        catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e) {
                // connection close failed.
                
            }
        }
    }
    
    public void regularExpression(String[] regExpression)
    {
        try
        {
             InputStream fstream = H2_DB_Test.class.getResourceAsStream("regExpression.txt");
             DataInputStream in = new DataInputStream(fstream);
             BufferedReader br = new BufferedReader(new InputStreamReader(in));
           
           
             //Read File Line By Line
             int tmp = 0;
             while ((regExpression[tmp] = br.readLine()) != null)   {
                 // Print the content on the console
                 //System.out.println (strLine[tmp]);
                 tmp++;
             }
             //Close the input stream
             in.close();
        }catch (Exception e){//Catch exception if any
            
        }
    }
    /**
     * @author Kyle
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        
        new H2_DB_Test();
        
    }
    
    public PlateInformation lookUp(String licenseNo, String location, String time)
    {
        boolean valid = false;
        // load the H2-JDBC driver using the current class loader
        PlateInformation results = null;
        licenseNo = licenseNo.toUpperCase();
        try
        {
           Class.forName("org.h2.Driver");

        }
        catch (ClassNotFoundException ex)
        {
           
           System.exit(-1);
        }
        Connection connection = null;
         try {
            // create a database connection
            // Parameters: database to connect to, username, password
            //connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb;MODE=MySQL;IGNORECASE=TRUE");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            LoggingInformation logNew = new LoggingInformation(licenseNo, location, time);
            writeToLoggingDb(logNew);           
            String[] regExpression;
            regExpression = new String[36];
            regularExpression(regExpression);
            String plateNo = licenseNo;
            String newPlateNo = "[A-Z0-9]*";
            int i = 0;
            int n = 0;
            int m = 2;           
            while(i < plateNo.length())
            {       
                while(plateNo.charAt(i) != regExpression[n].charAt(0))
                {
                    if (n < (regExpression.length - 1))
                    {
                       
                        n++;  
                    }
                    else
                    {
                        
                        break;
                    }
                }
                
                if (n >= (regExpression.length - 1))
                {
                    newPlateNo += "[A-Z0-9]*";
                    
                }
                else
                {
                   valid = true;
                    newPlateNo += "[" + regExpression[n].charAt(0);
                
                    while(m < regExpression[n].length())
                    {
                       newPlateNo += regExpression[n].charAt(m);
                       m++;
                    }
                
                    newPlateNo += "]";
                }
                m = 2;
                n = 0;                
                i++;
            }
            newPlateNo += "[A-Z0-9]*";
                                   

            //System.out.println("New License Plate = " + newPlateNo);
            String queryStatement = "SELECT * FROM permits WHERE plate REGEXP '" 
                    + newPlateNo + "'"; 
            // Send an SQL Query
            ResultSet rs = statement.executeQuery(queryStatement);
            if(valid == true)
            {
               while(rs.next())
               {
                  LoggingInformation newLog = new LoggingInformation(rs.getString("plate"), location, time);
                  writeToLoggingDb(newLog);
                  //writeToLoggingDb(rs.getString("plate"), location, time);
                  // read the result set
                  results = new PlateInformation(rs.getString("plate"), rs.getString("state"),
                        rs.getString("permit"), rs.getString("make"), rs.getString("model"), 
                        rs.getString("color"), rs.getString("numViolations"));
                  break;
               }
            }
            if(results == null)
            {
               results = new PlateInformation();
               //results.setPlate("Unknown");
            }
        }
        catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e) {
                // connection close failed.
                
            }
        }
        return (results);
    }
    
    public LoggingInformation lookUpLogging(String licenseNo)
    {
        // load the H2-JDBC driver using the current class loader
        LoggingInformation results = null;
        licenseNo = licenseNo.toUpperCase();
        try
        {
           Class.forName("org.h2.Driver");

        }
        catch (ClassNotFoundException ex)
        {
           
           System.exit(-1);
        }
        Connection connection = null;
         try {
            // create a database connection
            // Parameters: database to connect to, username, password
            //connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
                       
    
            String[] regExpression;
            regExpression = new String[36];
            regularExpression(regExpression);
            String plateNo = "";
            for(int i = 0; i < licenseNo.length(); i++)
            {
                if(licenseNo.charAt(i) == '?')
                {
                    plateNo += "[A-Z0-9]";
                }
                else
                {
                    plateNo += licenseNo.charAt(i);
                }
            }
            
            String queryStatement = "SELECT * FROM logging WHERE plate REGEXP '" 
                    + plateNo + "'"; 
            
            // Send an SQL Query
            ResultSet rs = statement.executeQuery(queryStatement);
            while(rs.next())
            {
                // read the result set
                results = new LoggingInformation(rs.getString("plate"), rs.getString("gps"),
                        rs.getString("time"));
                break;
            }
            
            
            // ASHCRAFT - You should not need to edit below this comment
        }
        catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e) {
                // connection close failed.
                
            }
        }
        return (results);
    }
    
    public void writeToLoggingDb(LoggingInformation newLog)
    {
        try
        {
           Class.forName("org.h2.Driver");

        }
        catch (ClassNotFoundException ex)
        {
           
           System.exit(-1);
        }
        
        Connection connection = null;
         try {
            // create a database connection
            // Parameters: database to connect to, username, password
            //connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate("DELETE FROM logging WHERE plate='" + newLog.getPlateNo() + "'");
            statement.executeUpdate("INSERT INTO logging VALUES('" + newLog.getPlateNo() 
                    + "', '" + newLog.getLocation() + "', '" + newLog.getTime() +"')");
        }
        catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e) {
                // connection close failed.
               
            }
        }
            
    }
     public void writeToPermitDb(PlateInformation newPlate)
    {
        try
        {
           Class.forName("org.h2.Driver");

        }
        catch (ClassNotFoundException ex)
        {
           
           System.exit(-1);
        }
        
        Connection connection = null;
         try {
            // create a database connection
            // Parameters: database to connect to, username, password
            //connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate("INSERT INTO permits VALUES('" + newPlate.getPlateNo() 
                    + "', '" + newPlate.getState() + "', '" + newPlate.getPermit() + "', '" 
                    + newPlate.getMake() + "', '" + newPlate.getModel() + "', '" 
                    + newPlate.getColor() + "', '" + newPlate.getNumViolations() + "')" );
        }
        catch(SQLException e) {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
        }
        finally {
            try {
                if(connection != null)
                    connection.close();
            }
            catch(SQLException e) {
                // connection close failed.
               
            }
        }
            
    }
}

