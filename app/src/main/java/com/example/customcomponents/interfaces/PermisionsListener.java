package com.example.customcomponents.interfaces;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * Generic Permission Listener help to easily integrate permissions. to extend of CustomPermissionHelper
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public interface PermisionsListener {

    int ENABLE_UNKNOWN_SOURCES = 1234;
    int GROUP_ALL = 150;
    int STORAGE_REQUEST = 151;
    int AUDIO_RECORD = 152;


    void onPermissions(int requestCode, String[] permissions, int[] grantResults);
}
