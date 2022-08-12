package com.example.customcomponents.utils;

import static com.example.customcomponents.interfaces.PermisionsListener.GROUP_ALL;

import android.app.Activity;
import android.content.pm.PackageManager;

import androidx.core.content.ContextCompat;

import com.example.customcomponents.interfaces.PermisionsListener;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will be Permission Utils.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class PermissionUtils {

    public static final String ANDROID_PERMISSION_RECEIVE_SMS = "android.permission.RECEIVE_SMS";

    public static final int GROUP_ALL_PERMISSIONS_REQUEST_CODE = GROUP_ALL;
    public static final int STORAGE_PERMISSION_REQUEST_CODE = PermisionsListener.STORAGE_REQUEST;

    public static boolean checkIfAlreadyhavePermission(Activity contex, String PERMISSION) {
        int result = ContextCompat.checkSelfPermission(contex, PERMISSION);
        if (result == PackageManager.PERMISSION_GRANTED) {
            return true;
        } else {
            return false;
        }
    }
}
