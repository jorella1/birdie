package com.revature.controller;
import io.javalin.http.Handler;
import java.util.*;
public class DashboardController {
    public static Handler Dashboard = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        Map<String,Integer> temp = new HashMap<>();
        System.out.println(ctx.pathParam("id"));
        // ArrayList<Integer> newarray = new ArrayList();
        // newarray.add(1);
        // newarray.add(2);
        temp.put("test", Integer.parseInt(ctx.pathParam("id")));
        temp.put("test1",5);
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

    
}
