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
        System.out.println(username);
        System.out.println(password);
        System.out.println("The new role is");
        System.out.println(ctx.formParam("Role"));
        String myrole = ctx.formParam("Role");
<<<<<<< HEAD
        System.out.println("my role is: "+myrole);
=======
        System.out.println("my role is "+myrole);

        if (myrole == null){

            String role ="user";
            userLoginEntity newuser = new userLoginEntity(username, password, role);
            userLoginDao mynewuser = new userLoginDao();
            System.out.println("my role");
            System.out.println(newuser.getRole());
            mynewuser.insert(newuser);
        }

        else if (myrole.equals("admin") ) {
            userLoginEntity newuser = new userLoginEntity(username, password, myrole);
            userLoginDao mynewuser = new userLoginDao();
            System.out.println("my role");
            System.out.println(newuser.getRole());
            mynewuser.insert(newuser);
>>>>>>> c400149508a11d18d6669862579053ea853475eb

        if (myrole == null ) {
      

<<<<<<< HEAD

            String role ="user";
            userLoginEntity newuser = new userLoginEntity(username, password, role);
            userLoginDao mynewuser = new userLoginDao();
            System.out.println("my role");
            System.out.println(newuser.getRole());
            mynewuser.insert(newuser);
        }

        

        else {

            userLoginEntity newuser = new userLoginEntity(username, password, myrole);
            userLoginDao mynewuser = new userLoginDao();
            System.out.println("my role");
            System.out.println(newuser.getRole());
            mynewuser.insert(newuser);


            // String role ="user";
            // userLoginEntity newuser = new userLoginEntity(username, password, role);
            // userLoginDao mynewuser = new userLoginDao();
            // System.out.println("my role");
            // System.out.println(newuser.getRole());
            // mynewuser.insert(newuser);
        }
=======
        }

    //    if (myrole == null){

    //         String role ="user";
    //         userLoginEntity newuser = new userLoginEntity(username, password, role);
    //         userLoginDao mynewuser = new userLoginDao();
    //         System.out.println("my role");
    //         System.out.println(newuser.getRole());
    //         mynewuser.insert(newuser);
    //     }
>>>>>>> c400149508a11d18d6669862579053ea853475eb
        // String role = ctx.formParam("role");

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
