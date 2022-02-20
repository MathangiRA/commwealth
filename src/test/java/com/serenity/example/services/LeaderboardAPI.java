package com.serenity.example.services;


import com.google.gson.Gson;
import io.restassured.response.Response;

import java.util.List;

public class LeaderboardAPI extends BaseService {

    public LeaderboardAPI() {
        super();
        BASE_URI = testProperties.getProperty("supervillainAPIURL") + testProperties.getProperty("leaderboard");
    }

    public UserList[] getUserList() {
        try {
            addAuthorization("");
            setContentType();
            addHeader("accept", "*/*");
            retrieveResponseByGET(BASE_URI);
            return (UserList[]) responseToObject(actualResponse.asString(), UserList[].class);
        } catch (Exception e) {
            LOG.error("Get User List" + "\n" + e.getMessage());
            return null;
        }
    }

    public int addOrUpdateUser(UserList user, boolean addUser) {
        try {
            addAuthorization("");
            setContentType();
            String body = new Gson().toJson(user).toString();
            requestSpecBuilder.setBody(body);
            addHeader("accept", "*/*");
            if (addUser)
                retrieveResponseByPOST(BASE_URI);
            else
                retrieveResponseByPUT(BASE_URI);
            return actualResponse.statusCode();
        } catch (Exception e) {
            LOG.error("Add User" + "\n" + e.getMessage());
            return 0;
        }
    }

    public int deleteUser(String userName) {
        try {
            addAuthorization("");
            setContentType();
            addHeader("delete-key", userName);
            addHeader("accept", "*/*");
            retrieveResponseByDELETE(BASE_URI);
            return actualResponse.statusCode();
        } catch (Exception e) {
            LOG.error("Add User" + "\n" + e.getMessage());
            return 0;
        }
    }


}
