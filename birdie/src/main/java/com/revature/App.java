package com.revature;

import java.sql.Connection;
import java.util.List;

import com.revature.repository.entities.postEntity;

// import org.eclipse.jetty.util.PathWatcher.Config;

// import com.revature.controller.HomeController;
// import com.revature.util.ConnectionFactory;

// import io.javalin.Javalin;
// import io.javalin.http.staticfiles.Location;
// import com.revature.repository.*;
import com.revature.repository.entities.userLoginEntity;
import com.revature.models.userLogin;
import com.revature.repository.userLoginDao;
import com.revature.repository.postDao;


public class App 
{
    public static void main( String[] args )
    {
        // Javalin app = Javalin.create(
        //     config -> {
        //         config.addStaticFiles("birdie/src/main/resources/public", Location.EXTERNAL);
        //     }
        // );
        // app.start(9090);
        // app.get("/", HomeController.homePageEntered);
        // Connection connection = ConnectionFactory.getConnection();
        // System.out.println(connection);
        // };

    //  userLoginEntity user = new userLoginEntity(0,"Myname1", "testpassword1");

    //  System.out.println("testing");
    //  System.out.println(user.getuserName());
    //  System.out.println(user.getPassword());
    
    // postEntity post = new postEntity(1, "making a new post");
     postDao newpost = new postDao();
    newpost.delete(3);
    //  newpost.updateText(1,"Hello");
    //  userLoginDao newuser = new userLoginDao();
    //  newuser.insert(user);
    //     userLoginEntity db_user=  newuser.select(1);
    //  System.out.println(db_user);
    //  List<userLoginEntity> users= newuser.selectAll();
        
     System.out.println("testing"); 

    //  for (int i=0; i<users.size(); i++){


    //     System.out.println(users.get(i).getuserName());

    //  }

    
        }

    }

