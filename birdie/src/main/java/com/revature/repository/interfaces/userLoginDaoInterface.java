package com.revature.repository.interfaces;

import java.util.List;

import com.revature.repository.entities.userLoginEntity;

public interface userLoginDaoInterface {
    

    void insert(userLoginEntity userLoginEntity);

    userLoginEntity select(int id);

    List<userLoginEntity> selectAll();

}

