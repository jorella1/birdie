package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.repository.entities.likeEntity;
import com.revature.repository.interfaces.userLoginDaoInterface;
import com.revature.repository.interfaces.likeDaoInterface;
import com.revature.repository.interfaces.postDaoInterface;
import com.revature.util.ConnectionFactory;

public class likeDao implements likeDaoInterface {

    @Override
    public void insert (likeEntity likeEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO project2.likes (postid, userid, hash) VALUES (?, ?,?);";


        // TODO Auto-generated method stub

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, likeEntity.getpostId());
            preparedStatement.setInt(2, likeEntity.getId());
            preparedStatement.setString(3, likeEntity.getHash());
            int row = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }

        
    }

    
    @Override
    public likeEntity select(String hash) {
        Connection connection = ConnectionFactory.getConnection();
                // TODO Auto-generated catch block
        String sql = "SELECT * FROM project2.likes WHERE hash=?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hash);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                
                return new likeEntity(
                    resultSet.getInt(1), 
                    resultSet.getInt(2), 
                    resultSet.getInt(3),
                    resultSet.getString(4)
                    );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    
}
