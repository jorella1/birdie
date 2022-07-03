package com.revature.controller;
import io.javalin.http.Handler;
import java.util.*;
public class LoginController {

    public static Handler loginPage = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        Map<String,Integer> temp = new HashMap<>();
        // System.out.println(ctx.pathParam("id"));
        // // ArrayList<Integer> newarray = new ArrayList();
        // // newarray.add(1);
        // // newarray.add(2);
        // temp.put("list_id", Integer.parseInt(ctx.pathParam("id")));
        // temp.put("test", Integer.parseInt(ctx.pathParam("id")));
        //  newvar = temp.get(1);
        ctx.render("/templates/loginpage.vm");
    };

    public static Handler login = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        // String username = ctx.formParam("username");
        // String password = ctx.formParam("password");

        // Map<String,Integer> temp = new HashMap<>();
        // System.out.println(ctx.pathParam("id"));
        // // ArrayList<Integer> newarray = new ArrayList();
        // // newarray.add(1);
        // // newarray.add(2);
        // temp.put("list_id", Integer.parseInt(ctx.pathParam("id")));
        // temp.put("test", Integer.parseInt(ctx.pathParam("id")));
        //  newvar = temp.get(1);
        // int id =1;
        String template = "status is %s, data key is %s";
       
        String url = "/my-list/%s";
        int id = 1;
        String result = String.format(url, id);

        ctx.redirect(result);    
        // ctx.render("/templates/dashboard.vm");
    };

    
}
