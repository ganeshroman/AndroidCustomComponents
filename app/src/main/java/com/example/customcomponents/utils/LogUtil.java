package com.example.customcomponents.utils;

import android.util.Log;

import com.example.customcomponents.BuildConfig;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will be logUtil
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
// Common logging Class to help Subscribe logs in multiple places. Disable all logs.
public class LogUtil {

    public static void logcatD(String key, String message) {
        if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug")) {
            Log.d("" + key, "" + message);
        }
    }


    public static void logcatE(String key, String message) {
        if (BuildConfig.BUILD_TYPE.equalsIgnoreCase("debug")) {
            Log.e("" + key, "" + message);
        }
    }
}


