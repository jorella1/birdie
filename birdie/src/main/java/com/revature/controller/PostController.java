package com.revature.controller;


import com.revature.repository.entities.postEntity;
import com.revature.repository.entities.userLoginEntity;
import com.revature.service.PostNotFoundException;
import com.revature.service.PostService;
import com.revature.models.*;
import com.revature.repository.*;

import io.javalin.http.Handler;
import java.util.*;

public class PostController {

    private static PostService PostServe = new PostService();
    // private static UserService UserServe = new UserService();
    // private static PostService PostService;
    // private static postEntity newPost;
    public static Handler make = ctx -> {
        System.out.println("The user is updated");
        // System.out.println(Integer.parseInt(ctx.formParam("username")));
        String text = ctx.formParam("text");
        int userid = Integer.parseInt(ctx.formParam("userid")); 
        userLoginDao userDao = new userLoginDao();
        userLoginEntity user = userDao.select(userid);
        System.out.println(user.getuserName());
        // String username=ctx.formParam("username");
        String username = user.getuserName();
        postEntity newPost= new postEntity(userid, text,username);


        PostServe.makePost(newPost);
        try{

        }catch(Exception e){
            System.out.println("The error is here "+e);
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    public static Handler Reply = ctx -> {
        System.out.println("The user is updated");
        // System.out.println(Integer.parseInt(ctx.formParam("username")));
        String text = ctx.formParam("text");
        int userid = Integer.parseInt(ctx.formParam("id")); 
        String username=ctx.formParam("username");
        int commentid = Integer.parseInt(ctx.formParam("postid"));
        postEntity newPost= new postEntity(userid, text,commentid,username);


        PostServe.makeReply(newPost);
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

    public static Handler getReplies = ctx -> {
        int postid = Integer.parseInt(ctx.pathParam("postid")); 
        try{
            ctx.json(PostServe.getReplies(postid));
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
