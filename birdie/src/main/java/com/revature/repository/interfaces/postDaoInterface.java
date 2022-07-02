package com.revature.repository.interfaces;

import java.util.List;

import com.revature.repository.entities.postEntity;

public interface postDaoInterface{
    
    //CRUD
    void insert(postEntity postEntity);

    postEntity select(int id);

    List<postEntity> selectAll();

    void updateText(int textid, String text);
    void updateLikes(int textid);
    void updateFlag(int textid, boolean flag);
    void delete(int postid);

}
