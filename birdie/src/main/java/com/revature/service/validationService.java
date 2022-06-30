package com.revature.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validationService { 

    
    //Length:5/15 Chars:az09 _ not as first or last
    public boolean validateUsername(String username){
        final String USERNAME_PATTERN =
            "^[a-zA-Z0-9]([_](?![_])|[a-zA-Z0-9]){3,13}[a-zA-Z0-9]$";
        Pattern pattern = Pattern.compile(USERNAME_PATTERN);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }
    //Length:8-20
    //Must have 1 numeric
    //at least one lower case and one upper case
    //at least one symbol @#$%!?
    public boolean validatePassword(String password){
        final String PASSWORD_PATTERN =
            "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!?]).{8,20}$";
        Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    //Length: Chars:
    public boolean validateFirstName(String firstName){
        String FIRSTNAME_PATTERN =
            "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){2,19}$";
        Pattern pattern = Pattern.compile(FIRSTNAME_PATTERN);
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();
    }
    //Length: Chars:
    public boolean validateLastName(String lastName){
        String LASTNAME_PATTERN =
            "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){2,19}$";
        Pattern pattern = Pattern.compile(LASTNAME_PATTERN);
        Matcher matcher = pattern.matcher(lastName);
        return matcher.matches();
    }
    //Length: Chars:
    public boolean validateEmail(String email){
        String EMAIL_PATTERN =
            "^[a-zA-Z0-9_+&*-] + (?:\\.[a-zA-Z0-9_+&*-] + )*@(?:[a-zA-Z0-9-]+\\.) + [a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    //Length: Chars:
    public boolean validateAddress(String address){
        return true;
    }
    //Length:10 Chars:integers
    public boolean validatePhone(String phone){
        String PHONE_PATTERN =
        "\\d{10}";
        Pattern pattern = Pattern.compile(PHONE_PATTERN);
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
    //Length:280 Chars:anything
    public boolean validatePostLength(String post){
        if(post.length() > 280){
            return false;
        }else
            return true;
    }

}