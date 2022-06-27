package com.revature.repository.entities;

public class postEntity {
    private int textid;
    private int userid;
    private String text;
    private int likes;

    public postEntity(int textid, int userid, String text, int likes) {
        this.textid = textid;
        this.userid = userid;
        this.text = text;
        this.likes = likes;
    }

    
    public postEntity(int userid, String text) {
        this.textid = 0;
        this.userid = userid;
        this.text = text;
        this.likes = 0;
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

    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }
    public void setLikes(int amount) {
        this.likes = amount ;
    }


    @Override
    public String toString() {
        return "Textid: "+  textid + " Userid: "+ userid + " Text: "+text +" Likes: "+likes;
    }

}
