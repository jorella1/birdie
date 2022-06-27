package com.revature.repository.entities;

public class userRegisterEntity {
    
    private int infoid;
    private int userid;
    private String first_name;
    private String last_name;
    private String email;
    private String address;
    private int phone_number;


    public userRegisterEntity(int infoid, int userid, String first_name, String last_name, String email, 
                            String address, int phone_number){
        
        this.infoid = infoid;
        this.userid=userid;
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.address=address;
        this.phone_number=phone_number;

    }


    public userRegisterEntity(int userid, String first_name, String last_name, 
                            String email, String address, int phone_number)
    {
        this.userid=userid;
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
        this.address=address;
        this.phone_number=phone_number;
    }


    public int getInfoid() {
        return infoid;
    }


    public void setInfoid(int infoid) {
        this.infoid = infoid;
    }


    public int getUserid() {
        return userid;
    }


    public void setUserid(int userid) {
        this.userid = userid;
    }


    public String getFirst_name() {
        return first_name;
    }


    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    public String getLast_name() {
        return last_name;
    }


    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }


    public int getPhone_number() {
        return phone_number;
    }


    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }


    @Override
    public String toString() {
        return "Infoid: "+  infoid + " Userid: "+ userid + " First Name: "+first_name +" Last Name: "+last_name 
                +"Email: "+email+"Address: "+ address+"Phone Number: "+phone_number;
    }


    
}
