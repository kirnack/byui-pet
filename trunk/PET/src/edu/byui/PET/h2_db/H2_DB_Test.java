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
       try { //Open database
          connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb;MODE=MySQL;IGNORECASE=TRUE");

          Statement statement = connection.createStatement();
          statement.setQueryTimeout(30);  // set timeout to 30 sec.
          // Send SQL Commands
          /*statement.executeUpdate("DROP TABLE IF EXISTS permits");
          statement.executeUpdate("CREATE TABLE permits (plate VARCHAR, state VARCHAR,"
                  + " permit VARCHAR, make VARCHAR, model VARCHAR, color VARCHAR, numViolations VARCHAR)");
          statement.executeUpdate("INSERT INTO permits VALUES('1M12345', 'IDAHO',"
                  + " 'N', 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('IMB2Z78', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M8Z72B', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          //statement.executeUpdate("CREATE INDEX IDX_PLATE ON permits(plate)");
          statement.executeUpdate("DROP TABLE IF EXISTS logging");
          statement.executeUpdate("CREATE TABLE logging (plate VARCHAR, gps VARCHAR, time VARCHAR)");
          //statement.executeUpdate("CREATE INDEX IDX_PLATE ON logging(plate)");
          statement.executeUpdate("INSERT INTO logging VALUES('1M12345', '157.201, 83.45', '14:35:35')");
          statement.executeUpdate("INSERT INTO permits VALUES('6617', 'MONTANA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('37063', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('10B6800', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('10B8502', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('169ZG0', 'WASHINGTON', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1AJP622', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1ASJ946', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1BK1098', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1BL4931', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J43903', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J45361', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J52463', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J53228', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J55383', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J58637', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J59696', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J59825', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J60386', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J61234', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J62505', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1J898', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M1033', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M1201', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M1418', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M1641', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M27140', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M2287T', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M33885', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M36691', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M3993', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M40080', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M43748', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M46', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M46321', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M46549', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M47T', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M48893', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M49039', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M49168', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M50200', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M50518', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M50786', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M52010', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M52016', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M52409', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M52409', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M53267', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M53970', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M53979', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M54211', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M54803', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M54959', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M55023', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M55055', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M55068', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M55103', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M56709', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M57484', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M57812', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M58440', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M59262', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M59414', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M59603', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M60938', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M61800', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M62202', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M6242', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M62575', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M63468', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M64848', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M655', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M65658', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M65768', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M6676', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M67700', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M68086', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M68922', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M69218', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M70201', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M70584', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M70943', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M70989', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71037', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71042', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71131', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71150', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71401', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71511', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71538', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71753', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M71931', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M72214', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M72913', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M73007', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M73910', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M73950', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M74132', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M74347', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M74761', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M75124', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M754', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M75470', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M76142', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M76294', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M76605', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M77191', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M77225', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M77766', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M77988', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78020', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78077', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78152', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78285', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78550', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78564', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78593', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M78947', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79368', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79422', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79533', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79709', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79773', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79828', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79856', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79962', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M79999', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M80032', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M80230', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M80626', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M80885', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M80891', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M81120', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M81122', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M81557', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M81780', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M82002', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M82216', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M82372', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M82628', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M83153', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M83644', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M83831', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M83907', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84140', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84194', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84236', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84245', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84426', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84508', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84647', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84694', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84863', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M84954', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M85377', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M85432', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M85451', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M8564', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M88662', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1O15518', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1P63947', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1T26066', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('202PIO', 'COLORADO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('238EMP', 'OREGON', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('258WPP', 'WASHINGTON', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2618CY', 'VIRGINIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2F18670', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2F23618', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2F24744', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2F32208', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2F33290', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2F4159', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2J39343', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2P105', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('2TS6554', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('3KDE120', 'CALIFORNIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('3MVY130', 'CALIFORNIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('444BE', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4BC3349', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4BE3481', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4BE5776', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4BE6477', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4BF2763', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4BG0067', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4C77818', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4CKU194', 'CALIFORNIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('4SEM694', 'CALIFORNIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('503DFH', 'OREGON', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('5239B', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('556PHX', 'COLORADO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('570WHJ', 'TENNESSE', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('594LYZ', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('5EGG864', 'CALIFORNIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('5RUA707', 'CALIFORNIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('5X65283', 'CALIFORNIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('5ZUX434', 'CALIFONIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('749EZF', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('893XHY', 'COLORADO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BAE464', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BAF394', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BA391', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BAX742', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BAY348', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BAY969', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BBH981', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BCF116', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BCJ668', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BN8542', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BONES', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BP8833', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BS0904', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BT9516', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BU5549', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BW2180', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BX7490', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BY7096', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BY7150', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BY9678', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BZ2603', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8BZ7051', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('8C1279', 'MONTANA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('955CWM', 'WASHINGTON', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('A522VG', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('AEH2091', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('AFC4144', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('ANY4185', 'COLORADO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('B525KP', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('B639FJ', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('B641VV', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('B757NJ', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('GOBIG1', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('K399387', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('K7RXF', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('KBK629', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('KEN4624', 'VIRGINIA', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('KENTD', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('SUBVT', 'IDAHO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('WA2D48', 'OREGON', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('WBL4088', 'MEXICO', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('ZO49WA', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('Z346TR', 'UTAH', 'S',"
                  + " 'CHEVY', 'IMPALA', 'WHITE', '0')");
          statement.executeUpdate("INSERT INTO permits VALUES('1M81780', 'IDAHO', 'S',"
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

    /*
     * This function reads in a file containing all of the regular expression matching.
     */
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

    /*
     * This function takes in a license plate number along with the gps coordinates and the time
     * where and when the license plate was seen, then searches the database to look for a possible match.
     * If there is a match then all of the information contained on the vehicle will be returned, 
     * otherwise null will be returned.
     */
    public PlateInformation lookUp(String licenseNo, String location, String time)
    {
        int valid = 0;//This value ensures that at least part of the license plate was found
        // load the H2-JDBC driver using the current class loader
        PlateInformation results = null;
        licenseNo = licenseNo.toUpperCase(); //Make sure license plate is upper case
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
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb;MODE=MySQL;IGNORECASE=TRUE");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            //Create an object to capture the logging data, then log the license plate just read into the database
            LoggingInformation logNew = new LoggingInformation(licenseNo, location, time);
            writeToLoggingDb(logNew);
            //Read in the regular expression file
            String[] regExpression;
            regExpression = new String[36];
            regularExpression(regExpression);
            String plateNo = licenseNo;
            //Put a wild card at the beginning of every search to improve accuracy
            String newPlateNo = "[A-Z0-9]*"; 
            int i = 0;
            int n = 0;
            int m = 2;
            //Replace every character read in from the license plate, with regular expressions
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
                   //If there is no match with the regular expression file, put in a wildcard 
                   newPlateNo += "[A-Z0-9]*";
                    
                }
                else
                {
                    valid++; //Indicate that at least part of the license plate was found
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
            //Add a wild card on the end of the plate to increase chances of matching
            newPlateNo += "[A-Z0-9]*"; 
            
            //Create SQL command
            String queryStatement = "SELECT * FROM permits WHERE plate REGEXP '"
                    + newPlateNo + "'";
            // Send an SQL Query
            
            //Only if part of the license plate was recognized will we search the database
            if(valid >= 2) 
            {
               ResultSet rs = statement.executeQuery(queryStatement);
               if(rs.next()) //Check is the license plate was found in database
               {
                  //Log the license plate, location, and time
                  LoggingInformation newLog = new LoggingInformation(rs.getString("plate"), location, time);
                  writeToLoggingDb(newLog); 
                  
                   // read the result set
                  results = new PlateInformation(rs.getString("plate"), rs.getString("state"),
                        rs.getString("permit"), rs.getString("make"), rs.getString("model"),
                        rs.getString("color"), rs.getString("numViolations"));
               }
            }
            if(results == null) //If no license plate was found, then initialize to ""
            {
               results = new PlateInformation();               
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

    /*
     * This function seached the logging table of the databse for a given license plate.
     * A LoggingInformation object is returned, filled up with a match found, or just null.
     */
    public LoggingInformation lookUpLogging(String licenseNo)
    {
        
        LoggingInformation results = null;
        licenseNo = licenseNo.toUpperCase();//Set the license plate upper case so it can be compared
        // load the H2-JDBC driver using the current class loader
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
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
           //Create SQL command
            String queryStatement = "SELECT * FROM logging WHERE plate REGEXP '"
                    + licenseNo + "'";

            // Send an SQL Query
           ResultSet rs = statement.executeQuery(queryStatement);
               if(rs.next())
               {
                   // read the result set
                  results = new LoggingInformation(rs.getString("plate"), rs.getString("gps"),
                           rs.getString("time"));
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
    
    /*
     * This function logs a license plate to the database. If the license plate already
     * exists in the database, then it is overwritten.
     */
    public void writeToLoggingDb(LoggingInformation newLog)
    {
       // load the H2-JDBC driver using the current class loader
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
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            
            //Delete any entry with a previous match of this license plate
            statement.executeUpdate("DELETE FROM logging WHERE plate='" + newLog.getPlateNo() + "'");
            //Write the license plate to the logging database
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
    
    /*
     * This function write to the permits table in the database a new license
     * plate, along with the state the license plate is registered, permit 
     * associated with the license plate, make, model, and color of car with
     * the license plate, and the number of violations the license plate has 
     * recieved.
     */
     public void writeToPermitDb(PlateInformation newPlate)
    {
       // load the H2-JDBC driver using the current class loader
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
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            //Write the information to the permits table in the database
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
     
    /*
      * This function is for updating the number of violations related to a license plate
      */
    public void ticket(PlateInformation violationPlate)
    {
       // load the H2-JDBC driver using the current class loader
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
            connection = DriverManager.getConnection("jdbc:h2:file:data/LicensePlateDb");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            //Update the number of violations
            statement.executeUpdate("UPDATE permits SET numViolations='" 
                    + violationPlate.getNumViolations() + "' WHERE plate='" + violationPlate.getPlateNo() + "'");
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

