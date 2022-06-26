package com.revature;

import java.sql.Connection;

import org.eclipse.jetty.util.PathWatcher.Config;

import com.revature.controller.HomeController;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create(
            config -> {
                config.addStaticFiles("birdie/src/main/resources/public", Location.EXTERNAL);
            }
        );
        app.start(9090);
        app.get("/", HomeController.homePageEntered);
        Connection connection = ConnectionFactory.getConnection();
        System.out.println(connection);
        };
    }

