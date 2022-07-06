package com.revature.controller;
import io.javalin.http.Handler;
import java.util.*;
import com.revature.repository.*;
import com.revature.repository.entities.userLoginEntity;
import com.revature.service.*;
public class DashboardController {


    private static PostService PostServe = new PostService();
    public static Handler Dashboard = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        Map<String,Integer> temp = new HashMap<>();

        System.out.println(ctx.pathParam("id"));
        int id =  Integer.parseInt(ctx.pathParam("id"));
      
        // ArrayList<Integer> newarray = new ArrayList();
        // newarray.add(1);
        // newarray.add(2);
        userLoginDao newuser = new userLoginDao();
        System.out.println("my new user id is "+id);
        userLoginEntity user = newuser.select(id);
        System.out.println("my role in dashboard is");
        System.out.println(user);
        System.out.println(user.getRole());
        String myrole = user.getRole();
        int adminid;
        if (myrole.equals("admin")){

            adminid =1;

        }

        else {

            adminid = 0;
        }

        temp.put("userid", Integer.parseInt(ctx.pathParam("id")));
        temp.put("role", adminid);
        // temp.put("role", user.getRole());
        
        temp.put("test1",5);
        //  newvar = temp.get(1);
        //  newvar = temp.get(1);
        ctx.render("/templates/dashboard.vm", temp);
    };
    public static Handler myList = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        Map<String,Integer> temp = new HashMap<>();
        System.out.println(ctx.pathParam("id"));
        // ArrayList<Integer> newarray = new ArrayList();
        // newarray.add(1);
        // newarray.add(2);
        temp.put("testing", Integer.parseInt(ctx.pathParam("id")));
        temp.put("testing1",5);
        //  newvar = temp.get(1);
        ctx.render("/templates/javascript.vm", temp);
    };


    public static Handler flaggedPosts = ctx -> {
        System.out.println("in the post server");
        
        ctx.json(PostServe.getFlaggedPosts());
    };

    public static Handler adminPage = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        Map<String,Integer> temp = new HashMap<>();
        // System.out.println(ctx.pathParam("id"));
        // // ArrayList<Integer> newarray = new ArrayList();
        // // newarray.add(1);
        // // newarray.add(2);
        // temp.put("list_id", Integer.parseInt(ctx.pathParam("id")));
        // temp.put("test", Integer.parseInt(ctx.pathParam("id")));
        //  newvar = temp.get(1);gu
        System.out.println("user id"+ctx.pathParam("userid"));
        int userid = Integer.parseInt(ctx.pathParam("userid"));
        temp.put("userid", Integer.parseInt(ctx.pathParam("userid")));
        ctx.render("/templates/admin.vm",temp);
    };

    
}
