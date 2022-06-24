package com.revature;

import java.sql.Connection;

import com.revature.util.ConnectionFactory;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Connection connection = ConnectionFactory.getConnection();
        System.out.println(connection);
    }
}
