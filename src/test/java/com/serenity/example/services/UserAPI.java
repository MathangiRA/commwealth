package com.serenity.example.services;


import com.google.gson.Gson;
import io.restassured.response.Response;

public class UserAPI extends BaseService {
    String USERREG = testProperties.getProperty("userRegister");
    String LOGIN = testProperties.getProperty("userLogin");

    public UserAPI() {
        super();
        BASE_URI = testProperties.getProperty("supervillainAPIURL");
    }

    public int registerUser(UserRegistrationRequest userReg, String token) {
        try {
            addAuthorization(token);
            String body = new Gson().toJson(userReg).toString();
            requestSpecBuilder.setBody(body);
            retrieveResponseByPOST(BASE_URI + USERREG);
            return actualResponse.statusCode();
        } catch (Exception e) {
            LOG.error("User Registration failed" + "\n" + e.getMessage());
            return 0;
        }
    }

    public UserLoginResponse userLogin(UserRegistrationRequest userReg) {
        try {
            addAuthorization("");
            String body = new Gson().toJson(userReg).toString();
            requestSpecBuilder.setBody(body);
            retrieveResponseByPOST(BASE_URI + LOGIN);
            return (UserLoginResponse) responseToObject(actualResponse.asString(), UserLoginResponse.class);
        } catch (Exception e) {
            LOG.error("User Login failed" + "\n" + e.getMessage());
            return null;
        }
    }


}
