package com.revature.repository.interfaces;

import java.util.List;

import com.revature.repository.entities.postEntity;

public interface postDaoInterface{
    
    //CRUD
    void insert(postEntity postEntity);
    void insert_comment(postEntity postEntity);

    postEntity select(int id);

    List<postEntity> selectAll();
    List<postEntity> selectAllFlagged();
    List<postEntity> selectReplies(int postid);
    void updateText(int textid, String text);
    void updateLikes(int textid);
    void updateFlag(int textid, boolean flag);
    void delete(int postid);

}
