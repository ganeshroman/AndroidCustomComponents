package com.example.customcomponents.models.connectivity;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will read file from Local and gives output in string
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class InAppJson {

    public static String readJSONFromAsset(String filename, Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
