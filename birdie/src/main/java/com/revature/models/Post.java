package com.revature.models;

public class Post {
  
    private int postid;
    // private int userid;
    private String post;
    private int likes=0;
    private boolean flag = false;
    private int commentid=0;

    private String username;


    public Post(int postid, String post, int likes,String username) {
        this.postid=postid;
        this.post=post;
        this.username=username;
    }
    public Post(int postid, String post, int likes,String username,int commentid) {
        this.postid=postid;
        this.post=post;
        this.username=username;
        this.commentid=commentid;
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

    public int getcommentId() {
        return commentid;
    }
    public void setcommentId(int commentid) {
        this.commentid = commentid;
    }



    public void setUsername(String username) {

        this.username=username;

    }

    public String getUsername(){

        return username;
    }

    public boolean getFlag(){

        return flag;
    }

    public void setFlag(boolean flag) {

        this.flag=flag;

    }
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        if(postid != other.postid){
            return false;
        }
        if (post == null) {
            if (other.post != null)
                return false;
        } else if (!post.equals(other.post))
            return false;
        if (flag != other.flag){
            return false;
        }
        return true;
    }

    @Override
    public String toString() { 
        
        return "Postid: "+postid + " Post: "+ post + " Likes: "+likes;

    }
    
}
