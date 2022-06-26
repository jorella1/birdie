package com.revature.models;

public class posts {
  
    private int postid;
    private int userid;
    private String post;
    private int likes;
    public posts(String post) {
        this.post=post;
        this.likes=0;
    }
    public int getId() {
        return postid;
    }
    public void setId(int id) {
        this.postid =id;
    }

    public int getuserId() {
        return userid;
    }
    public void setuserId(int id) {
        this.userid =id;
    }

    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    public String getLikes() {
        return post;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }


    @Override
    public String toString() { 
        
        return "Postid: "+postid+ " Userid: "+ userid + " Post: "+ post + " Likes: "+likes;

    }
    
}
