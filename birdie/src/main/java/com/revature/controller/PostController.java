package com.revature.controller;


import com.revature.repository.postDao;
import com.revature.repository.entities.postEntity;
import com.revature.service.PostNotFoundException;
import com.revature.service.PostService;
import com.revature.models.*;

import io.javalin.http.Handler;

public class PostController {

    private static PostService PostServe = new PostService();
    // private static UserService UserServe = new UserService();
    // private static PostService PostService;
    // private static postEntity newPost;
    public static Handler make = ctx -> {
        System.out.println("The user is updated");
        // System.out.println(Integer.parseInt(ctx.formParam("username")));
        String text = ctx.formParam("text");
        int userid = Integer.parseInt(ctx.formParam("id")); 
        
        postEntity newPost= new postEntity(userid, text);


        PostServe.makePost(newPost);
        try{

        }catch(Exception e){
            System.out.println("The error is here "+e);
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };
    public static Handler allPostsHandler = ctx -> {
        System.out.println("in the post server");
        
        ctx.json(PostServe.getAllPosts());
    };


    public static Handler getPost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            ctx.json(PostServe.getPost(id));
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    // public static Handler reportPost = ctx -> {
    //     int id = Integer.parseInt(ctx.pathParam("id")); 
    //     try{
    //         ctx.json(PostService.report(id));
    //     }catch(PostNotFoundException e){
    //         ctx.result("Item Not Found");
    //         ctx.status(400);
    //     }
    // };

    public static Handler likePost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
           PostServe.likePost(id);
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };


    public static Handler editPost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            PostServe.editPost(id, ctx.formParam("text"));
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    public static Handler flagPost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            PostServe.flagPost(id);
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };


    public static Handler deletePost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        try{
            PostServe.deletePost(id);
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    
}
