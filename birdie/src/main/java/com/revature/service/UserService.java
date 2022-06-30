package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.repository.userLoginDao;
import com.revature.repository.entities.userLoginEntity;

public class UserService {

    private userLoginDao userLoginDao;



    public Post getUser(int id) throws UserNotFoundException {
        return convertUserModel(userLoginDao.select(id));
    }

    public void deleteUser(int id) throws UserNotFoundException {
        userLoginDao.delete(id);
    }


    public List<User> getAllUsers() throws UserNotFoundException {
        List<userLoginEntity> UserEntities = userLoginDao.selectAll();
        List<User> UserModels = new ArrayList<>();

        for (userLoginEntity UserEntity : UserEntities){
            UserModels.add(convertUserModel(UserEntity));
        }

        return UserModels;
    }

    private static User convertUserModel(userLoginEntity userLoginEntity) throws UserNotFoundException {
        if(userLoginEntity == null){
            throw new UserNotFoundException();
        }
        return new User(
            userLoginEntity.getId(), 
            userLoginEntity.getuserName(), 
            userLoginEntity.getPassword() 
            );
    }


}
