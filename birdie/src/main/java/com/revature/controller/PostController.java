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
        // String usernamFe=ctx.formParam("username");
        String username = user.getuserName();
        postEntity newPost= new postEntity(userid, text,username);


        PostServe.makePost(newPost);
      
       
        String url = "/dashboard/%s";
        String result = String.format(url, userid);

        ctx.redirect(result);    
        try{

        }catch(Exception e){
            System.out.println("The error is here "+e);
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    public static Handler Reply = ctx -> {
        System.out.println("The user is updated");
        System.out.println(ctx.formParam("username"));
        String text = ctx.formParam("text");
        int postid = Integer.parseInt(ctx.formParam("button")); 
        int userid =  Integer.parseInt(ctx.pathParam("userid")); 
        String username=ctx.formParam("username");
        int commentid = Integer.parseInt(ctx.formParam("button"));
        System.out.println("the commentid value is "+commentid);
        userLoginDao userDao = new userLoginDao();
        userLoginEntity newuser = userDao.select(userid);
        System.out.println("my user id is "+newuser.getuserName());
        String userreply = newuser.getuserName();
        postEntity newPost= new postEntity(userid, text,commentid,userreply);


        PostServe.makeReply(newPost);
    
        // http://localhost:9090/posting//${userid}/${postid}
        String url ="/posting/%s/%s";
        // String url = "/dashboard/%s";
        String result = String.format(url, userid,postid);

        ctx.redirect(result);   

        try{

        }catch(Exception e){
            System.out.println("The error is here "+e);
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };


    public static Handler allPostsHandler = ctx -> {
        System.out.println("in the post server");
        System.out.println("****************************************");
        System.out.println(PostServe.getAllPosts());
        System.out.println("printing out all the posts");
        ctx.json(PostServe.getAllPosts());
    };

    public static Handler searchPostsHandler = ctx -> {
        System.out.println("in the searchposthandler server ---------------------------------------------");
        String search = ctx.pathParam("search");
        // String search = ctx.formParam("searchField");
        System.out.println(search);
        
        // Map<String,String> temp = new HashMap<>();
        // temp.put("searches", search);

    
        // // temp.put("test1",5);
        // //  newvar = temp.get(1);
        //  ctx.render("/templates/search.vm", temp);

   
        ctx.json(PostServe.getSearchedPosts(search));
    };

    public static Handler searchHandler = ctx -> {
        System.out.println("in the searchposthandler server ---------------------------------------------");
        String search = ctx.formParam("searchField");
        String userid= ctx.pathParam("userid");
        System.out.println(search);

        Map<String,String> temp = new HashMap<>();
        temp.put("searches", search);
        temp.put("userid", userid);

        
        // temp.put("test1",5);
        //  newvar = temp.get(1);
         ctx.render("/templates/search.vm", temp);

   
        // ctx.json(PostServe.getSearchedPosts(search));
    };

    // public static Handler searchPage = ctx -> {
    //     System.out.println("in the get postpage");
    //    System.out.println("post param");
    //   System.out.println(ctx.pathParam("postid")); 
    //   System.out.println(ctx.pathParam("userid")); 
    //     int id = Integer.parseInt(ctx.pathParam("postid"));
    //     Map<String,Integer> temp = new HashMap<>();
    //     temp.put("postid", Integer.parseInt(ctx.pathParam("postid")));
    //     temp.put("userid", Integer.parseInt(ctx.pathParam("userid")));
        
    //     // temp.put("test1",5);
    //     //  newvar = temp.get(1);
    //      ctx.render("/templates/post.vm", temp);
    //     // ctx.html("testing");
    //         // ctx.json(PostServe.getPost(id));

    // };



    // public static Handler Search = ctx -> {
    //     System.out.println("in the post server");
        
    //     ctx.json(PostServe.getAllPosts());
    // };


    public static Handler allFlaggedPostsHandler = ctx -> {
        System.out.println("in the post server");
        
        ctx.json(PostServe.getFlaggedPosts());
    };


    public static Handler getPost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("postid")); 
        try{
            ctx.json(PostServe.getPost(id));
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    public static Handler getPostPage = ctx -> {
        System.out.println("in the get postpage");
       System.out.println("post param");
      System.out.println(ctx.pathParam("postid")); 
      System.out.println(ctx.pathParam("userid")); 
        int id = Integer.parseInt(ctx.pathParam("postid"));
        Map<String,Integer> temp = new HashMap<>();
        temp.put("postid", Integer.parseInt(ctx.pathParam("postid")));
        temp.put("userid", Integer.parseInt(ctx.pathParam("userid")));
        
        // temp.put("test1",5);
        //  newvar = temp.get(1);
         ctx.render("/templates/post.vm", temp);
        // ctx.html("testing");
            // ctx.json(PostServe.getPost(id));

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
        int postid = Integer.parseInt(ctx.pathParam("postid")); 
        int userid =  Integer.parseInt(ctx.pathParam("userid")); 

        String template = "status is %s, data key is %s";
       
        String url = "/dashboard/%s";
        String result = String.format(url, userid);

        ctx.redirect(result);    
        try{
           PostServe.likePost(postid,userid);
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
        int postid = Integer.parseInt(ctx.pathParam("postid")); 

        String template = "status is %s, data key is %s";
       

        // System.out.println("my result is");
        // System.out.println(result);
        postDao post = new postDao();
        postEntity mypost = post.select(postid);
        int userid = mypost.getId();
        String url = "/dashboard/%s";
        String result = String.format(url, userid);

        ctx.redirect(result);    
        try{
            PostServe.flagPost(postid);
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };


    public static Handler deletePost = ctx -> {
        int id = Integer.parseInt(ctx.pathParam("id")); 
        System.out.println("deleting");
        try{
            PostServe.deletePost(id);
        }catch(PostNotFoundException e){
            ctx.result("Item Not Found");
            ctx.status(400);
        }
    };

    
}
