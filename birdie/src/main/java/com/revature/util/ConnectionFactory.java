package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static Connection connection;


    public static Connection getConnection(){

        System.out.println("in the get connection method");
        if(connection != null){
            // If the connection has already been made then I will return
            // The same connection
            System.out.println("connection is not null");
            return connection;
        }else{
            // I have to make the connection
            System.out.println("in the else if");
            try{
                connection = DriverManager.getConnection(
                "jdbc:postgresql://p0-database.cvzbvdn4nh5s.us-west-1.rds.amazonaws.com/", 
                "postgres", 
                "password123");
                return connection;
            }catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }
    }

}
