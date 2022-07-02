package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.repository.userLoginDao;
import com.revature.repository.entities.userLoginEntity;

public class UserService {

    private userLoginDao userLogin= new userLoginDao();

    private static User User = new User(4,"hello", "test", "user");

    public User getUser(int id) {
        System.out.println("I'm in user service");
        User testuser= convertUserModel(userLogin.select(id));
        System.out.println(testuser);
        // return convertUserModel(userLoginDao.select(id));
        // return convertUserModel(userLoginDao.select(id));
        System.out.println("after test user");
         return testuser;
    }

    public void registerUser(userLoginEntity newuser) {

        userLogin.insert(newuser);
        // return convertUserModel(userLoginDao.select(id));
        // return convertUserModel(userLoginDao.select(id));

    }

    // public void deleteUser(int id) throws UserNotFoundException {
    //     userLoginDao.delete(id);
    // }


    public List<User> getAllUsers() throws UserNotFoundException {
        List<userLoginEntity> UserEntities = userLogin.selectAll();
        List<User> UserModels = new ArrayList<>();

        for (userLoginEntity UserEntity : UserEntities){
            UserModels.add(convertUserModel(UserEntity));
        }

        return UserModels;
    }

    private static User convertUserModel(userLoginEntity userLoginEntity){
        System.out.println("in convert model");
        if(userLoginEntity == null){
            System.out.println("testing convert");
        }
        return new User(
            userLoginEntity.getId(), 
            userLoginEntity.getuserName(), 
            userLoginEntity.getPassword(),
            userLoginEntity.getRole() 
            );
    }


}
