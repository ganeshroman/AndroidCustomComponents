package com.example.customcomponents.models.connectivity;

import com.example.customcomponents.utils.LogUtil;

import okhttp3.logging.HttpLoggingInterceptor;

public class LoggingInterceptor implements HttpLoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        LogUtil.logcatD("Network Call", "message: "+message);
        //Log.e("Network Call", "message: "+message);
    }
}
