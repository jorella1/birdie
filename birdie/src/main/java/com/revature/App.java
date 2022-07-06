package com.revature;

import java.sql.Connection;
import java.util.List;

import com.revature.repository.entities.postEntity;

import org.eclipse.jetty.util.PathWatcher.Config;

import com.revature.controller.HomeController;
import com.revature.controller.PostController;
import com.revature.controller.LoginController;
import com.revature.util.ConnectionFactory;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import com.revature.repository.*;
import com.revature.repository.entities.userLoginEntity;
import com.revature.repository.entities.userRegisterEntity;
import com.revature.models.User;
import com.revature.controller.*;
import com.revature.repository.userLoginDao;
import com.revature.repository.userRegisterDao;
import com.revature.repository.postDao;

import io.javalin.Javalin;
import io.javalin.apibuilder.ApiBuilder;
import io.javalin.http.staticfiles.Location;
import com.revature.jte.*;
import static io.javalin.apibuilder.ApiBuilder.*;


public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create(
            config -> {
                config.addStaticFiles("birdie/src/main/resources/public", Location.EXTERNAL);
            }
        );
        app.start(9090);
        String myhtml = "<h1>testing</h1>";
        // app.get("/", HomeController.homePageEntered);
        int id =1;
        app.get("/", ctx -> ctx.redirect("index.html"));
        app.get("/dashboard/{id}", DashboardController.Dashboard);
        // app.get("/{postid}",PostController.getPostPage);
       
        // Map<String,Integer> temp = new HashMap<>();
        //         temp.put("list_id", Integer.parseInt(ctx.formParam("list_id")));
                // ctx.render("/templates/index.vm", temp);

        app.get("/my-list/{id}", DashboardController.myList);
        app.post("/registration", RegistrationController.register);
        app.get("/loginpage", LoginController.loginPage);
        app.post("/login", LoginController.login);
        app.get("/admin/{userid}", DashboardController.adminPage);
        app.get("/search/{search}", PostController.searchPostsHandler);
        app.post("/searchpage/{userid}", PostController.searchHandler);
        Connection connection = ConnectionFactory.getConnection();
        System.out.println(connection);

        ////Post routes

        app.routes(() -> {
            path("posting", () -> {
                get("all", PostController.allPostsHandler);
                get("reply/{postid}",PostController.getReplies);
                post("make", PostController.make);
                post("reply/{userid}/{postid}", PostController.Reply);
                get("post/{postid}", PostController.getPost);
                get("like/{userid}/{postid}", PostController.likePost);
                get("delete/{id}", PostController.deletePost);
                get("flag/{postid}", PostController.flagPost);
                get("{userid}/{postid}",PostController.getPostPage);
                get("makereply/{postid}", PostController.flagPost);
                get("/flagged", PostController.allFlaggedPostsHandler);
                
                
                // get("update/{id}", PostController.update);
                // get("report/{id}", PostController.report);
                // get("delete/{id}", PostController.delete);

            });
        
        });
        

        ///User

        app.routes(() -> {
            path("user", () -> {
                get("all", UserController.allUserHandler);
                get("{id}", UserController.getUser);
                get("register", UserController.register);
                
                // get("report/{id}", UserController.report);
                // get("delete/{id}", UserController.delete);
                
            });
        });

       String username="sdfsdf";
        
        postEntity post = new postEntity(1,"24th post", 5, username);

        System.out.println("testing");
        System.out.println(post);
        postDao poster = new postDao();
        System.out.println("my commentid "+post.getcommentId());
        poster.insert_reply(post); 
        poster.updateLikes(1);
        postEntity posterE = poster.select(1);
        System.out.println("My ilkes are");
        int likes= posterE.getLikes()+1;
        System.out.println(posterE.getLikes());
        poster.updateLikes(1);
        poster.delete(4);
        poster.updateFlag(5, true);
        poster.updateFlag(10, true);
        List<postEntity> posterF = poster.selectAll();
        System.out.println(posterF);
        System.out.println(posterF.get(0).getFlag());
        
        System.out.println(posterF);
        }


    }
        // };




    // userRegisterEntity new_user = new userRegisterEntity(0, 2, "mr.", "birdie"
    //                                 , "birdie@gmail.com", "657 street", 1234567890);

    
    // System.out.println("New User");
    // System.out.println(new_user.getFirst_name());
    // System.out.println(new_user.getLast_name());
    // System.out.println(new_user.getEmail());
    // System.out.println(new_user.getAddress());
    // System.out.println(new_user.getPhone_number());

    // userRegisterDao user_new = new userRegisterDao();
    // user_new.insert(new_user);
    //user_new.delete(1);
    
    // postEntity post = new postEntity(1, "making a new post");
     //postDao newpost = new postDao();
    //newpost.delete(3);
    //  newpost.updateText(1,"Hello");
    //  userLoginDao newuser = new userLoginDao();
    //  newuser.insert(user);
    //     userLoginEntity db_user=  newuser.select(1);
    //  System.out.println(db_user);
    //  List<userLoginEntity> users= newuser.selectAll();
        
     //System.out.println("testing"); 

    //  for (int i=0; i<users.size(); i++){


    //     System.out.println(users.get(i).getuserName());

    //  }

    

