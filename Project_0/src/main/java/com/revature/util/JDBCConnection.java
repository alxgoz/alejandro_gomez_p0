package com.revature.util;

// Imports from java.sql -> JDBC
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
Java™ database connectivity (JDBC) is the JavaSoft specification of a standard (API)
 that allows Java programs to access database management systems. The JDBC API consists of
  a set of interfaces and classes written in the Java programming language.
 */

public class JDBCConnection {

  /*
We are going to create a similar idea to what is called a Singleton.
Singleton -> Design Pattern in which you only ever want One instance
of the Object to ever exist.

- Prevent additional Object creations by privatization our constructor
and creating a public method that controls when if at all a new Object is created.
     */

    private static Connection conn = null;

    public static Connection getConnection(){

        /*
        getConnection responsibility will be...
        To establish a new connection if one doesn't exist,
        otherwise return the current connection.

        Credentials: url (endpoint), username, password
         */

        if (conn == null) {
            // Establish a new connection

            //  Set up a connection property file in the resources package to hide sensitive information
            Properties props = new Properties();
            try {
 // Use FileReader to load the file location into props
 // props.load(new FileReader("src/main/resources/connection.properties"));
//  Not such a great way with its nested file location bc Maven might mess something up packaging the project
     // This is the better way ...
    props.load(JDBCConnection.class.getClassLoader().getResourceAsStream("connection.properties"));


                String endpoint = props.getProperty("endpoint");
                // String endpoint = "alejandro2201javareact.cekziltlbpq3.us-east-1.rds.amazonaws.com";
                //URL Format (postgressql JDBC)
                //JDBC:postgresql://[endpoint]/[database]

                String url = "jdbc:postgresql://" + endpoint + "/postgres";
                //String username = "alejandro";
                String username = props.getProperty("username");
                //String password = "password123";
                String password = props.getProperty("password");

                conn = DriverManager.getConnection(url, username, password);

            } catch (IOException | SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
        /*
       THIS IS FOR TESTING PURPOSES ONLY!!!!!!!!!!!!!!
       NOT NEEDED TO ACTUALLY USE JDBC
        */
        public static void main(String[] args) {

            Connection conn1 = getConnection();
            System.out.println(conn1);
            // Test Passed!!!

            //  Second Test -> that another conn is the same connection
            Connection conn2 = getConnection();
            System.out.println(conn2);
            // Second Test Passed!!!

        }

}









