package com.revature.controller;


import com.revature.repository.userLoginDao;
import com.revature.service.UserNotFoundException;
import com.revature.service.UserService;

import io.javalin.http.Handler;

public class UserController {

    // private static ItemService itemService;

    public static Handler allUsersHandler = ctx -> {
        ctx.json(UserService.getAllUsers());
    };


    public static Handler getUser = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            ctx.json(UserService.getUser(id));
        }catch(UserNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    public static Handler reportUser = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            ctx.json(UserService.report(id));
        }catch(UserNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    

    public static Handler deleteUser = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            ctx.json(UserService.deleteUser(id));
        }catch(UserNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    
}
