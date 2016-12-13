package com.danieleautizi.restapi.model;

import com.google.gson.Gson;

public class RestApiResponse {

    private String status;
    private String data;
    private String message;
 
    public RestApiResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestApiResponse(String status, String data, String message) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String getStatus() {
        return status;
    }
 
    public String getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

}
