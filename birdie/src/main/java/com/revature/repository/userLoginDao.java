package com.revature.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.repository.entities.userLoginEntity;
import com.revature.repository.interfaces.userLoginDaoInterface;
import com.revature.util.ConnectionFactory;

public class userLoginDao implements userLoginDaoInterface{

    @Override
    public void insert(userLoginEntity userLoginEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO project2.userlogin (username, password, role) VALUES (?,?,?)   RETURNING userid;";

        System.out.println("inserting");
        // TODO Auto-generated method stub

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, userLoginEntity.getuserName());
            preparedStatement.setString(2, userLoginEntity.getPassword());
            preparedStatement.setString(3, userLoginEntity.getRole());
            preparedStatement.executeUpdate();
            // int id = row;
            // System.out.println("my id is "+row);
       

        }catch(SQLException e){
            e.printStackTrace();
        }

 
      
    }
        
    
    
    @Override
    public userLoginEntity select(int id) {
        Connection connection = ConnectionFactory.getConnection();
                // TODO Auto-generated catch block
        String sql = "SELECT * FROM project2.userlogin WHERE userid=?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                
                return new userLoginEntity(
                    resultSet.getInt(1), 
                    resultSet.getString(2), 
                    resultSet.getString(3),
                    resultSet.getString(4)
                    );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public userLoginEntity select_by_username(String username) {
        Connection connection = ConnectionFactory.getConnection();
                // TODO Auto-generated catch block
        String sql = "SELECT * FROM project2.userlogin WHERE username=?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                
                return new userLoginEntity(
                    resultSet.getInt(1), 
                    resultSet.getString(2), 
                    resultSet.getString(3),
                    resultSet.getString(4)
                    );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<userLoginEntity> selectAll() {
        Connection connection = ConnectionFactory.getConnection();
                // TODO Auto-generated catch block
        String sql = "SELECT * FROM project2.userlogin;";

        List<userLoginEntity> items = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){


                items.add(new userLoginEntity(
                    resultSet.getInt(1), 
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4)
                    ));
            }
        

        }catch(SQLException e){
            e.printStackTrace();
        }
        return items;
    }
    
}
