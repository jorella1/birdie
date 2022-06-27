package com.revature.repository.entities;

public class userLoginEntity {
    private int userid;
    private String username;
    private String password;

    public userLoginEntity(int userid, String username, String password) {
        this.userid = userid;
        this.username =username;
        this.password = password;
    }

    public userLoginEntity( String username, String password) {
        this.username =username;
        this.password = password;
    }

    public int getId() {
        return userid;
    }
    public void setId(int userid) {
        this.userid = userid;
    }
    public String getuserName() {
        return username;
    }
    public void setuserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Userid: "+ userid + " Username: "+ username + " Password: "+password;
    }

}
