package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Post;
import com.revature.repository.postDao;
import com.revature.repository.entities.postEntity;

public class PostService {

    private postDao PostDao;



    public Post getPost(int id) throws PostNotFoundException {
        return convertPostModel(PostDao.select(id));
    }

    public void deletePost(int id) throws PostNotFoundException {
        PostDao.delete(id);
    }


    public List<Post> getAllPosts() throws PostNotFoundException {
        List<postEntity> PostEntities = PostDao.selectAll();
        List<Post> PostModels = new ArrayList<>();

        for (postEntity PostEntity : PostEntities){
            PostModels.add(convertPostModel(PostEntity));
        }

        return PostModels;
    }

    public void editPost(int id, String text) throws PostNotFoundException {
        PostDao.updateText(id, text);
    }


    private static Post convertPostModel(postEntity PostEntity) throws PostNotFoundException {
        if(PostEntity == null){
            throw new PostNotFoundException();
        }
        return new Post(
            PostEntity.getTid(), 
            PostEntity.getText(), 
            PostEntity.getLikes() 
            );
    }


}
