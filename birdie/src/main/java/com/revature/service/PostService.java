package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Post;
import com.revature.repository.postDao;
import com.revature.repository.entities.postEntity;

public class PostService {

    private postDao Posts= new postDao();

    public void makePost(postEntity newpost) throws PostNotFoundException {
        Posts.insert(newpost);
        // return convertPostModel(Posts.select(id));
    }



    public Post getPost(int id) throws PostNotFoundException {
        return convertPostModel(Posts.select(id));
    }

    public void deletePost(int id) throws PostNotFoundException {
        Posts.delete(id);
    }


    public List<Post> getAllPosts() throws PostNotFoundException {
        System.out.println("in the get all posts");
        List<postEntity> PostEntities = Posts.selectAll();
        System.out.println(PostEntities);
        List<Post> PostModels = new ArrayList<>();

        for (postEntity PostEntity : PostEntities){
            PostModels.add(convertPostModel(PostEntity));
        }

        return PostModels;
    }

    public void editPost(int id, String text) throws PostNotFoundException {
        Posts.updateText(id, text);
    }
    public void likePost(int id) throws PostNotFoundException {
        // postEntity post= Posts.select(id);
        // int newlikes=post.getLikes()+1;
        Posts.updateLikes(id);
    }

    public void flagPost(int id) throws PostNotFoundException {
        Posts.updateFlag(id,true);
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
    //for mocking and testing purposes
    public void setPostDao(postDao PostDao){
        this.Posts = PostDao;
    }


}
