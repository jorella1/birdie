package com.revature.repository.entities;

public class postEntity {
    private int textid;
    private int userid;
    private String text;
    private int likes;
    private boolean flag;
    private int commentid=0;
    private String username;

    public postEntity(int textid, int userid, String text, int likes, boolean flag, int commentid, String username) {
        this.textid = textid;
        this.userid = userid;
        this.text = text;
        this.likes = likes;
        this.flag = flag;
        this.commentid=0;
        this.username =username;
    }

    
    public postEntity(int userid, String text, String username) {
        this.textid = 0;
        this.userid = userid;
        this.text = text;
        this.likes = 0;
        this.flag = false;
        this.username=username;
    }

    public postEntity(int userid, String text, int commentid, String username) {
        this.textid = 0;
        this.userid = userid;
        this.text = text;
        this.likes = 0;
        this.flag = false;
        this.commentid=commentid;
        this.username =username;
    }

    public int getTid() {
        return textid;
    }
    public void setTid(int textid) {
        this.textid = textid;
    }

    public int getId() {
        return userid;
    }
    public void setId(int userid) {
        this.userid = userid;
    }

    public int getcommentId() {
        return commentid;
    }
    public void setcommentId(int commentid) {
        this.commentid = commentid;
    }

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public int getLikes() {
        return likes;
    }
    public void setLikes(int amount) {
        this.likes = amount ;
    }

    public boolean getFlag(){

        return flag;
    }

    public void setFlag (boolean flag){


        this.flag = flag;
    }


    @Override
    public String toString() {
        return "Textid: "+  textid + " Userid: "+ userid + " Text: "+text +" Likes: "+likes;
    }

}
