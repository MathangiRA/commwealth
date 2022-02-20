package com.serenity.example.services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserList {
    @SerializedName("username")
    @Expose
    private String username;

    @SerializedName("score")
    @Expose
    private int score;

    public String getUsername(){
        return username;
    }

    public int getScore(){
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public UserList(String username, int score){
        this.username = username;
        this.score = score;
    }

}