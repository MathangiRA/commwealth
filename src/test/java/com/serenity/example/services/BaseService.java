package com.serenity.example.services;

import com.google.gson.Gson;
import com.serenity.example.utilities.Config;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ConnectionConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class BaseService {

    final static Logger LOG = LoggerFactory.getLogger(BaseService.class);
    Properties testProperties;
    public String BASE_URI = "";
    public String TOKEN = "";
    public RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    public BaseService() {
        Config config = new Config();
        testProperties = config.initializeConfig();
        TOKEN = testProperties.getProperty("token");
    }

    public static Scenario scenario;
    public Response actualResponse = null;

    public void addHeader(String attribute, String value) {
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put(attribute, value);
        requestSpecBuilder.addHeaders(header);
    }

    protected void setContentType(){
        addHeader("ContentType", ContentType.JSON.toString());
    }
    public void addAuthorization(String token){
        if (token.isEmpty()) {
            addHeader("Authorization", TOKEN);
        } else {
            addHeader("Authorization", token);
        }
    };

    public void addQueryParam(String attribute, String value) {
        requestSpecBuilder.addQueryParam(attribute, value);
    }

    protected void printLog(String message) {
        scenario.log(message);
        LOG.info(message);
    }

    public Object responseToObject(String resp, Class mapperClass) {
        Gson g = new Gson();
        return g.fromJson(resp, mapperClass);
    }

    public Response retrieveResponseByGET(String URLrequest) {
        actualResponse = SerenityRest.
                given()
                .relaxedHTTPSValidation().
                        spec(requestSpecBuilder.build()).
                        when().
                        log().
                        all().
                        contentType("application/json; charset=UTF-8;").
                        get(URLrequest).
                        then().
                        log().
                        all().
                        extract().
                        response();

        return actualResponse;
    }
    public Response retrieveResponseByPOST(String URL) {
        actualResponse = SerenityRest.
                given()
                .relaxedHTTPSValidation().
                        spec(requestSpecBuilder.build()).
                        when().
                        log().
                        all().
                        contentType("application/json;  charset=UTF-8").
                        post(URL).
                        then().
                        log().
                        all().
                        extract().
                        response();

        return actualResponse;
    }

    public Response retrieveResponseByDELETE(String URL) {
        actualResponse = SerenityRest.
                given()
                .relaxedHTTPSValidation().
                        spec(requestSpecBuilder.build()).
                        when().
                        log().
                        all().
                        contentType("application/json;  charset=UTF-8").
                        delete(URL).
                        then().
                        log().
                        all().
                        extract().
                        response();

        return actualResponse;
    }

    public Response retrieveResponseByPUT(String URL) {
        actualResponse = SerenityRest.
                given()
                .relaxedHTTPSValidation().
                        spec(requestSpecBuilder.build()).
                        when().
                        log().
                        all().
                        contentType("application/json;  charset=UTF-8").
                        put(URL).
                        then().
                        log().
                        all().
                        extract().
                        response();

        return actualResponse;
    }

}
