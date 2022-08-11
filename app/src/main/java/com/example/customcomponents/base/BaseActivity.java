package com.example.customcomponents.base;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.pm.PermissionInfo;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;

import com.example.customcomponents.interfaces.PermisionsListener;
import com.example.customcomponents.utils.Helper;
import com.example.customcomponents.utils.PermissionUtils;

public class BaseActivity extends AppCompatActivity {

    private PermisionsListener listener = null;

    public boolean checkIfAlreadyhavePermission(String PERMISSION) {
        return PermissionUtils.checkIfAlreadyhavePermission(this, PERMISSION);
    }

    /*TODO: Add Listener for permision granted or denied*/
    public void requestWriteStoragePermission(PermisionsListener listener) {
        this.listener = listener;
        if (!checkIfAlreadyhavePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            requestPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    PermissionUtils.STORAGE_PERMISSION_REQUEST_CODE);
        }
    }

    public void requestAudioStoragePermission(PermisionsListener listener) {
        this.listener = listener;
        if (!checkIfAlreadyhavePermission(Manifest.permission.RECORD_AUDIO)) {
            requestPermission(Manifest.permission.RECORD_AUDIO,
                    PermisionsListener.AUDIO_RECORD);
        }
    }


    public void requestPermission(PermisionsListener listener, String PERMISSION, int REQUEST_CODE) {
        this.listener = listener;
        requestPermission(PERMISSION, REQUEST_CODE);
    }

    public void requestPermission(final String PERMISSION, int REQUEST_CODE) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!checkIfAlreadyhavePermission(PERMISSION)) { //Manifest.permission.WRITE_EXTERNAL_STORAGE
                requestPermissions(
                        new String[]{PERMISSION},
                        REQUEST_CODE);
            }
        }
    }

    public void addPermissionAsManifest(final String PERMISSION) {
        PermissionInfo permissionInfo = new PermissionInfo();
        //permissionInfo.name = ANDROID_PERMISSION_RECEIVE_SMS;
        permissionInfo.name = PERMISSION;
        this.getPackageManager().addPermission(permissionInfo);
    }


    public void showMessage(String msg) {
        Helper.showMessage(this, msg);
    }

    private boolean isLocalSession() {
        // Check session

        return false;
    }

    public void checkSessionInvalidation() {
        // Logout session
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PermissionUtils.STORAGE_PERMISSION_REQUEST_CODE: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted,
                    // storage-related task you need to do.
                } else {

                    // permission denied! Disable.
                    // functionality that depends on this permission.
                    showMessage("Permission denied to write your External storage");
                }
                break;
            }


            // other 'case' lines to check for other
            // permissions this app might request
        }

        if (listener != null) {
            listener.onPermissions(requestCode, permissions, grantResults);
        }
    }


    @Override
    public void onStart() {
        super.onStart();
        Helper.hideKeyboard(this);
        //checkSessionInvalidation();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Helper.hideKeyboard(this);
    }


}

