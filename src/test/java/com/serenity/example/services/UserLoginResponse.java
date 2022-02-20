package com.serenity.example.services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserLoginResponse {
    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("expiresIn")
    @Expose
    private String mins;

    public String getToken(){
        return token;
    }

    public String getExpires(){
        return mins;
    }

}