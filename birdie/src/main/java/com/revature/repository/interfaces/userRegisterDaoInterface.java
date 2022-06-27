package com.revature.repository.interfaces;

import java.util.List;

import com.revature.repository.entities.userRegisterEntity;

public interface userRegisterDaoInterface {

    void insert(userRegisterEntity userRegisterEntity);

    userRegisterEntity select(int userId);

    List<userRegisterEntity> selectAll();

    void delete(int infoid);


    
}
