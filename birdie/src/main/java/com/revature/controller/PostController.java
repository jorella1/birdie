package com.revature.controller;


import com.revature.repository.postDao;
import com.revature.service.PostNotFoundException;
import com.revature.service.PostService;

import io.javalin.http.Handler;

public class PostController {

    // private static ItemService itemService;

    public static Handler allPostsHandler = ctx -> {
        ctx.json(PostService.getAllPosts());
    };


    public static Handler getPost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            ctx.json(PostService.getPost(id));
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    public static Handler reportPost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            ctx.json(PostService.report(id));
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    
    public static Handler editPost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            ctx.json(PostService.edit(id, ctx.formParam("text")));
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    public static Handler deletePost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            ctx.json(PostService.deletePost(id));
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    
}
