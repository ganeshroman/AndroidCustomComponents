package com.example.customcomponents.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StdResponse {

    public static final String RES_SUCCESS = "200";
    public static final String RES_ERROR = "3000";
    public static final String RES_NO_DATA = "3004";


    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @SerializedName("responseType")
    @Expose
    String responseType = new String();

    @SerializedName("statusCode")
    @Expose
    String statusCode = new String();

    @SerializedName("status")
    @Expose
    String status = new String();
}
