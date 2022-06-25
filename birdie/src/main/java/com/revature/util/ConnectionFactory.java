package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static Connection connection;


    public static Connection getConnection(){
        
        if(connection != null){
            // If the connection has already been made then I will return
            // The same connection
            return connection;
        }else{
            // I have to make the connection
            try{
                connection = DriverManager.getConnection(
                "jdbc:postgresql://p2-database.c9nrebfnqjzt.us-east-2.rds.amazonaws.com:5432/p2_database", 
                "postgres", 
                "project2");
                return connection;
            }catch(SQLException e){
                e.printStackTrace();
                return null;
            }
        }
    }

}
