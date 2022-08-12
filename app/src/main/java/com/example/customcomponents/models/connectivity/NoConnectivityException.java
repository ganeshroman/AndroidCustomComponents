package com.example.customcomponents.models.connectivity;


import java.io.IOException;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will throws exception.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class NoConnectivityException extends IOException {

    public static final String NO_INTERNET = "No Internet available!";

    @Override
    public String getMessage() {
        return NO_INTERNET;
    }
}
