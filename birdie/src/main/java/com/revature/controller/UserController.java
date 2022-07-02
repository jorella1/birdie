package com.revature.controller;


import com.revature.repository.userLoginDao;
import com.revature.repository.entities.userLoginEntity;
import com.revature.service.UserNotFoundException;
import com.revature.service.UserService;
import com.revature.models.*;
import io.javalin.http.Handler;

public class UserController {

     private static UserService UserServe = new UserService();
     private static User User = new User(4,"hi", "test", "user");
     public static Handler allUserHandler = ctx -> {
         ctx.json(UserServe.getAllUsers());
    };


    public static Handler getUser = ctx -> {
        System.out.println("The user is updated");
        System.out.println(Integer.parseInt(ctx.pathParam("id")));
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            System.out.println("before ctx json");
            // System.out.println(User);
            System.out.println(User);
            User myuser= UserServe.getUser(id);
             ctx.json(myuser);
            // ctx.json(User);
            System.out.println("after ctx json");
        }catch(Exception e){
            System.out.println("The error is here "+e);
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    public static Handler register = ctx -> {
        System.out.println("The user is updated");
        // System.out.println(Integer.parseInt(ctx.formParam("username")));
        String username = ctx.formParam("username"); 
        String password = ctx.formParam("password"); 
        String role = ctx.formParam("role");
        userLoginEntity newuser = new userLoginEntity(username, password, role);
        // postEntity newPost= new postEntity(userid, text);
        UserServe.registerUser(newuser);
        try{

        }catch(Exception e){
            System.out.println("The error is here "+e);
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };


    // public static Handler reportUser = ctx -> {
    //     int id = Integer.parseInt(ctx.pathParam("id")); 
    //     try{
    //         ctx.json(UserService.report(id));
    //     }catch(UserNotFoundException e){
    //         ctx.result("Item Not Found");
    //         ctx.status(400);
    //     }
    // };

    

    // public static Handler deleteUser = ctx -> {
    //     int id = Integer.parseInt(ctx.pathParam("id")); 
    //     try{
    //         UserService.deleteUser(id);
    //     }catch(UserNotFoundException e){
    //         ctx.result("Item Not Found");
    //         ctx.status(400);
    //     }
    // };

    
}
