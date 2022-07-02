package com.revature.models;

public class User {
    private String username;
    private String password;
    private int userid;
    private String role;
    public User(int userid, String username, String password, String role) {
        this.userid=userid;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return userid;
    }
    public void setId(int userid) {
        this.userid= userid;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
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

    // @Override
    // public String toString() { 
        
    //     return "Userid: "+ userid + " Username: "+ username + " Password: "+password;

    // }
    
}
