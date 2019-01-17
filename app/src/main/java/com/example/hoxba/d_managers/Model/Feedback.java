package com.example.hoxba.d_managers.Model;

public class Feedback {
    String userId;
    String name;
    String occupation;
    String phone;
    String description;
    String address;

    public Feedback() {

    }

    public Feedback(String userId,String name,String occupation,String phone,String description,String address){
        this.userId=userId;
        this.name=name;
        this.occupation=occupation;
        this.phone=phone;
        this.description=description;
        this.address=address;
    }

    public String getuserId(){
        return userId;
    }
    public String getname(){
        return name;
    }
    public String getoccupation(){
        return occupation;
    }
    public String getphone(){
        return phone;
    }
    public String getdescription(){
        return description;
    }
    public String getaddress(){
        return address;
    }



}