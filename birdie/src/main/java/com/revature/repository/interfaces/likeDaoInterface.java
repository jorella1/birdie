package com.revature.repository.interfaces;

import java.util.List;

import com.revature.repository.entities.likeEntity;

public interface likeDaoInterface{
    
    //CRUD
    void insert(likeEntity likeEntity);

    likeEntity select(String hash);

}
