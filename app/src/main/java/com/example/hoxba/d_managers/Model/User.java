package com.example.hoxba.d_managers.Model;

public class User {
    public String user_email, user_password,user_fname,user_pass;

    public User() {

    }

    public User(String user_name,  String user_password) {
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_fname=user_fname;
        this.user_pass=user_pass;


    }

    public String getuser_email() {
        return user_email;
    }

    public void setuser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getuser_password() {
        return user_password;
    }

    public void setuser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getuser_fname() {
        return user_fname;
    }

    public void setuser_fname(String user_fname) {
        this.user_fname = user_fname;
    }

    public String getuser_pass() {
        return user_pass;
    }

    public void setuser_pass(String user_pass) {
        this.user_pass = user_pass;
    }


}