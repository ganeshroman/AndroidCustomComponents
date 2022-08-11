package com.example.customcomponents.models.connectivity;


import java.io.IOException;

public class NoConnectivityException extends IOException {

    public static final String NO_INTERNET = "No Internet available!";

    @Override
    public String getMessage() {
        return NO_INTERNET;
    }
}
