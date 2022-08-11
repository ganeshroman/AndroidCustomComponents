package com.example.customcomponents.interfaces;

public interface PermisionsListener {

    int ENABLE_UNKNOWN_SOURCES = 1234;
    int GROUP_ALL = 150;
    int STORAGE_REQUEST = 151;
    int AUDIO_RECORD=152;


    void onPermissions(int requestCode, String[] permissions, int[] grantResults);
}
