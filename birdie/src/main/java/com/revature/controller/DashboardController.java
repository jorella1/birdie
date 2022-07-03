package com.revature.controller;
import io.javalin.http.Handler;
import java.util.*;
public class DashboardController {
    public static Handler Dashboard = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        ctx.html("dashboard.html");
    };
    public static Handler myList = ctx -> {
        // System.out.println("the parameter id is "+ctx.pathParam("id"));
        // ctx.render("/dashboard.html");
        Map<String,Integer> temp = new HashMap<>();
        System.out.println(ctx.pathParam("id"));
        // ArrayList<Integer> newarray = new ArrayList();
        // newarray.add(1);
        // newarray.add(2);
        temp.put("list_id", Integer.parseInt(ctx.pathParam("id")));
        temp.put("test", Integer.parseInt(ctx.pathParam("id")));
        //  newvar = temp.get(1);
        ctx.render("/templates/javascript.vm", temp);
    };

    
}
