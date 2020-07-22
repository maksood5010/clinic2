package com.example.user.clinic;

public class User {
    private String name,email,password;
    private int user_id;


    public int getUserid(){
        return user_id;
    }
    public void setUserid(int id){
        this.user_id=id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
