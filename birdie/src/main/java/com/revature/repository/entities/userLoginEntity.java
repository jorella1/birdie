package com.revature.repository.entities;

public class userLoginEntity {
    private int userid;
    private String username;
    private String password;
    private String role;

    public userLoginEntity(int userid, String username, String password, String role) {
        this.userid = userid;
        this.username =username;
        this.password = password;
        this.role = role;
    }

    public userLoginEntity( String username, String password, String role) {
        System.out.println("in the userlogin entity role: "+role);
        this.username =username;
        this.password = password;
        this.role = role;
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


    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Userid: "+ userid + " Username: "+ username + " Password: "+password;
    }

}
