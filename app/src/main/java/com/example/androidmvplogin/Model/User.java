package com.example.androidmvplogin.Model;


import android.text.TextUtils;
import android.util.Patterns;

public class User implements  IUser {

    private String email,password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;

    }

    @Override
    public int isValidData() {

        //1 check email is empty
        //2 check email matches patter
        //3 check password length >6
        if(TextUtils.isEmpty(getEmail()))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if (getPassword().length() <= 6)
            return 2;
        else
            return -1;

    }
}
