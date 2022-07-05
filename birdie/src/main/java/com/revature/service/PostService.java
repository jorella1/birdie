package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.Post;
import com.revature.repository.postDao;
import com.revature.repository.likeDao;
import com.revature.repository.entities.likeEntity;
import com.revature.repository.entities.postEntity;
public class PostService {

    private postDao Posts= new postDao();
    private likeDao Likes = new likeDao();

    public void makePost(postEntity newpost) throws PostNotFoundException {
        Posts.insert(newpost);
        // return convertPostModel(Posts.select(id));
    }


    public void makeReply(postEntity newpost) throws PostNotFoundException {
        Posts.insert_reply(newpost);
        // return convertPostModel(Posts.select(id));
    }


    public Post getPost(int id) throws PostNotFoundException {
        return convertPostModel(Posts.select(id));
    }

    public List<Post> getReplies(int postid) throws PostNotFoundException {
        System.out.println("in the get all posts");
        List<postEntity> PostEntities = Posts.selectReplies(postid);
        System.out.println("THIS IS THE POST ENTITIES");
        System.out.println(PostEntities);
        List<Post> PostModels = new ArrayList<>();

        for (postEntity PostEntity : PostEntities){
            PostModels.add(convertPostModel(PostEntity));
        }

        return PostModels;
    }

    public void deletePost(int id) throws PostNotFoundException {
        if(getPost(id) == null){
            throw new PostNotFoundException();
        }
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


    public List<Post> getSearchedPosts(String search) throws PostNotFoundException {
        System.out.println("*************************************************************");
        System.out.println("in the get all search posts");
        List<postEntity> PostEntities = Posts.selectAll();
        System.out.println("post entities");
        System.out.println(PostEntities);
        List<Post> PostModels = new ArrayList<>();

        for (postEntity post : PostEntities) {

            String text =post.getText();
            if (text.contains(search)){
                PostModels.add(convertPostModel(post));

            }
        }

        return PostModels;
    }


    // public List<Post> getSearchedPosts() throws PostNotFoundException {
    //     System.out.println("in the get all posts");
    //     List<postEntity> PostEntities = Posts.selectAll();
    //     System.out.println(PostEntities);
    //     For (postEntity)
    //     List<Post> PostModels = new ArrayList<>();

    //     for (postEntity PostEntity : PostEntities){
    //         PostModels.add(convertPostModel(PostEntity));
        
    //     }

    //     return PostModels;
    // }


   

    public List<Post> getFlaggedPosts() throws PostNotFoundException {
        System.out.println("in the get all posts");
        List<postEntity> PostEntities = Posts.selectAllFlagged();
        System.out.println(PostEntities);
        List<Post> PostModels = new ArrayList<>();

        for (postEntity PostEntity : PostEntities){
            PostModels.add(convertPostModel(PostEntity));
        
        }

        return PostModels;
    }

    public void editPost(int id, String text) throws PostNotFoundException {
        if(getPost(id) == null){
            throw new PostNotFoundException();
        }
        Posts.updateText(id, text);
    }
    public void likePost(int postid, int userid) throws PostNotFoundException {
        // postEntity post= Posts.select(id);
        // int newlikes=post.getLikes()+1;
        System.out.println("in like post");
        if(getPost(postid) == null){
            throw new PostNotFoundException();
        }

        String hash;
        String postSt=String.valueOf(postid);
        String userSt=String.valueOf(userid);
        hash = postSt + userSt;
        likeEntity mylike = Likes.select(hash);
        if (mylike==null){

            likeEntity like = new likeEntity(postid, userid, hash);
            Likes.insert(like);
            
            Posts.updateLikes(postid);

        }

    }

    public void flagPost(int id) throws PostNotFoundException {
        if(getPost(id) == null){
            throw new PostNotFoundException();
        }
     
        Posts.updateFlag(id,true);
    }

    private static Post convertPostModel(postEntity PostEntity) throws PostNotFoundException {
        
        if(PostEntity == null){
            throw new PostNotFoundException();
        }
        return new Post(
            PostEntity.getTid(), 
            PostEntity.getText(), 
            PostEntity.getLikes(),
            PostEntity.getUsername()
            );
    }
    //for mocking and testing purposes
    public void setPostDao(postDao PostDao){
        this.Posts = PostDao;
    }


}
