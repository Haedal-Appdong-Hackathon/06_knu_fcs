package com.example.practice;

public class Account {
    private static String ID = "";
    private String nickname;

    public static String getID() {
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