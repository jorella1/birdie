package com.revature.models;

public class Post {
  
    private int postid;
    // private int userid;
    private String post;
    private int likes;
    private boolean flag = false;
    private int commentid;

    private String username;


    public Post(int postid, String post, int likes,String username) {
        this.postid=postid;
        this.post=post;
        this.username=username;
        this.likes=likes;
    }
    public Post(int postid, String post, int likes,String username,int commentid) {
        this.postid=postid;
        this.post=post;
        this.username=username;
        this.commentid=commentid;
        this.likes=likes;
    }
    public int getId() {
        return postid;
    }
    public void setId(int postid) {
        this.postid =postid;
    }


    public String getPost() {
        return post;
    }
    public void setPost(String post) {
        this.post = post;
    }

    public int getLikes() {
        return likes;
    }
    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getcommentid() {
        return commentid;
    }
    public void setcommentid(int commentid) {
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
