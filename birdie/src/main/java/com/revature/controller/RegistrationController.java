package com.revature.controller;
import io.javalin.http.Handler;
import java.util.*;
import com.revature.repository.*;
import com.revature.repository.entities.userLoginEntity;
public class RegistrationController {

    public static Handler register = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        Map<String,Integer> temp = new HashMap<>();
        // System.out.println(ctx.pathParam("id"));
        // // ArrayList<Integer> newarray = new ArrayList();
        String username = ctx.formParam("username");
        String password = ctx.formParam("password");
        // String role = ctx.formParam("role");
        String role ="Admin";
        userLoginEntity newuser = new userLoginEntity(username, password, role);
        userLoginDao mynewuser = new userLoginDao();
        mynewuser.insert(newuser);
        // // newarray.add(1);
        // // newarray.add(2);
        // temp.put("list_id", Integer.parseInt(ctx.pathParam("id")));
        // temp.put("test", Integer.parseInt(ctx.pathParam("id")));
        //  newvar = temp.get(1);
        System.out.println(username);
        System.out.println(ctx.formParam("username"));
        System.out.println("we signed up");
        ctx.redirect("/");
    };


    // public static Handler registrer = ctx -> {
    //     // System.out.println("the parameter id is "+ctx.pathParam("id"));
    //     // ctx.render("/dashboard.html");
    //     Map<String,Integer> temp = new HashMap<>();
    //     // System.out.println(ctx.pathParam("id"));
    //     // // ArrayList<Integer> newarray = new ArrayList();
    //     // // newarray.add(1);
    //     // // newarray.add(2);
    //     // temp.put("list_id", Integer.parseInt(ctx.pathParam("id")));
    //     // temp.put("test", Integer.parseInt(ctx.pathParam("id")));
    //     //  newvar = temp.get(1);
    //     ctx.redirect(re);
    // };
    
}
