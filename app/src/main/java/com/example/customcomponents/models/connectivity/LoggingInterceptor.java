package com.example.customcomponents.models.connectivity;

import com.example.customcomponents.utils.LogUtil;

import okhttp3.logging.HttpLoggingInterceptor;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * Custom Login interceptor.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class LoggingInterceptor implements HttpLoggingInterceptor.Logger {

    @Override
    public void log(String message) {
        LogUtil.logcatD("Network Call", "message: " + message);
        //Log.e("Network Call", "message: "+message);
    }
}
