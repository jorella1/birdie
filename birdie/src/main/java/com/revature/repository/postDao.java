package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.repository.entities.postEntity;
import com.revature.repository.interfaces.userLoginDaoInterface;
import com.revature.repository.interfaces.postDaoInterface;
import com.revature.util.ConnectionFactory;

public class postDao implements postDaoInterface {

    @Override
    public void insert (postEntity postEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO project2.posts (userid, text) VALUES (?, ?);";


        // TODO Auto-generated method stub

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, postEntity.getId());
            preparedStatement.setString(2, postEntity.getText());
            int row = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }
        
    
    
    @Override
    public postEntity select(int postid) {
        Connection connection = ConnectionFactory.getConnection();
                // TODO Auto-generated catch block
        String sql = "SELECT * FROM project2.posts WHERE postid=?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, postid);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                
                return new postEntity(
                    resultSet.getInt(1), 
                    resultSet.getInt(2), 
                    resultSet.getString(3),
                    resultSet.getInt(4));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<postEntity> selectAll() {
        Connection connection = ConnectionFactory.getConnection();
                // TODO Auto-generated catch block
        String sql = "SELECT * FROM project2.posts;";

        List<postEntity> posts = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){


                posts.add(new postEntity(
                    resultSet.getInt(1), 
                    resultSet.getInt(2),
                    resultSet.getString(3),
                    resultSet.getInt(4)
                    ));
            }
        

        }catch(SQLException e){
            e.printStackTrace();
        }
        return posts;
    }



    @Override
    public void updateText(int postid, String text){

        Connection connection = ConnectionFactory.getConnection();
        // String sql = "INSERT INTO project2.posts (userid, texts) VALUES (?, ?});";
        String sql = "UPDATE project2.posts SET text=? WHERE postid=?;";


        // TODO Auto-generated method stub

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, text);
            preparedStatement.setInt(2, postid);
            int row = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void updateLikes(int postid, int likes){

        Connection connection = ConnectionFactory.getConnection();
        // String sql = "INSERT INTO project2.posts (userid, texts) VALUES (?, ?});";
        String sql = "UPDATE project2.posts SET likes=? WHERE postid=?;";


        // TODO Auto-generated method stub

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, likes);
            preparedStatement.setInt(2, postid);
            int row = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    @Override
    public void delete(int postid){

        Connection connection = ConnectionFactory.getConnection();
        // String sql = "INSERT INTO project2.posts (userid, texts) VALUES (?, ?});";
        String sql = "DELETE FROM project2.posts WHERE postid=?;";


        // TODO Auto-generated method stub

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, postid);
            int row = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }


    }


    
}
