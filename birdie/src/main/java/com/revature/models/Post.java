package com.revature.models;

public class Post {
  
    private int postid;
    // private int userid;
    private String post;
    private int likes=0;
    private boolean flag = false;

    public Post(int postid, String post, int likes) {
        this.postid=postid;
        this.post=post;
    }
    public int getId() {
        return postid;
    }
    public void setId(int id) {
        this.postid =id;
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

    public boolean getFlag(){

        return flag;
    }

    public void setFlag(boolean flag) {

        this.flag=flag;

    }


    @Override
    public String toString() { 
        
        return "Postid: "+postid + " Post: "+ post + " Likes: "+likes;

    }
    
}
