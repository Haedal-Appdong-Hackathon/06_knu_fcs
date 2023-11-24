package com.example.practice;

public class Account {
    private String ID;
    private String nickname;

    public String getID() {
        return ID;
    }
    public String getNickname() {
        return nickname;
    }
    public void setUser(String ID, String nickname) {
        this.ID = ID;
        this.nickname = nickname;
    }
}