package com.revature.models;

public class userLogin {
    private String username;
    private String password;
    private int userid;
    public userLogin(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() { 
        
        return "Userid: "+ userid + " Username: "+ username + " Password: "+password;

    }
    
}
