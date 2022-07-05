package com.revature.repository.entities;

public class likeEntity {
    private int likeid;
    private int postid;
    private int userid;
    private String hash;


    public likeEntity(int likeid, int postid, int userid, String hash) {
        this.likeid= likeid;
        this.postid=postid;
        this.userid = userid;
        this.hash = hash;
    }

    public likeEntity( int postid, int userid, String hash) {
        this.postid=postid;
        this.userid = userid;
        this.hash = hash;
    }


    public int getLid() {
        return likeid;
    }
    public void setLid(int textid) {
        this.likeid = likeid;
    }

    public int getId() {
        return userid;
    }
    public void setId(int userid) {
        this.userid = userid;
    }

    public int getpostId() {
        return postid;
    }
    public void setpostId(int postid) {
        this.postid = postid;
    }

    public String getHash() {
        return hash;
    }
    public void setHash(String hash) {
        this.hash = hash;
    }


    @Override
    public String toString() {
        return "Likeid: "+  likeid + "Postid :" +postid +" Userid: "+ userid + " hash: "+hash;
    }

}
