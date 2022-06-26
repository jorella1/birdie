package com.revature.repository;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.repository.entities.userRegisterEntity;
import com.revature.repository.interfaces.userRegisterDaoInterface;
import com.revature.util.ConnectionFactory;

public class userRegisterDao implements userRegisterDaoInterface {

    @Override
    public void insert (userRegisterEntity userRegisterEntity) {
        Connection connection = ConnectionFactory.getConnection();
        String sql = "INSERT INTO project2.userinfo (userid, first_name, last_name, email, address, phone_number) VALUES (?, ?, ?, ?, ?, ?);";


        // TODO Auto-generated method stub

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, userRegisterEntity.getUserid());
            preparedStatement.setString(2, userRegisterEntity.getFirst_name());
            preparedStatement.setString(3, userRegisterEntity.getLast_name());
            preparedStatement.setString(4, userRegisterEntity.getEmail());
            preparedStatement.setString(5, userRegisterEntity.getAddress());
            preparedStatement.setInt(6, userRegisterEntity.getPhone_number());
            int row = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }

    }
        
    
    
    @Override
    public userRegisterEntity select(int userId) {
        Connection connection = ConnectionFactory.getConnection();
                // TODO Auto-generated catch block
        String sql = "SELECT * FROM project2.userinfo WHERE userid=?;";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                
                return new userRegisterEntity(
                    resultSet.getInt(1), 
                    resultSet.getInt(2), 
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getInt(7));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<userRegisterEntity> selectAll() {
        Connection connection = ConnectionFactory.getConnection();
                // TODO Auto-generated catch block
        String sql = "SELECT * FROM project2.userinfo;";

        List<userRegisterEntity> user = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){


                user.add(new userRegisterEntity(
                    resultSet.getInt(1), 
                    resultSet.getInt(2), 
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getInt(7))
                );
            }
        

        }catch(SQLException e){
            e.printStackTrace();
        }
        return user;
    }


    @Override
    public void delete(int infoid){

        Connection connection = ConnectionFactory.getConnection();
        String sql = "DELETE FROM project2.userinfo WHERE userid=?;";


        // TODO Auto-generated method stub

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, infoid);
            int row = preparedStatement.executeUpdate();


        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    
}
