package com.example.customcomponents.global;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.os.Build;

import com.example.customcomponents.AppInfoActivity;
import com.example.customcomponents.MainActivity;
import com.example.customcomponents.R;

import java.util.Arrays;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * For shortcuts of app
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class AppShortcut {

    public static final String HOME_SHORT = "Home page";
    public static final String HOME_LONG = "This will show home page.";

    public static final String ABOUT_SHORT = "About app";
    public static final String ABOUT_LONG = "This will show about page.";


    public static void setShortcut(Context contex) {

    }


    public static void setShortcutHomeDynamic(Activity contex, boolean createShortcut) {
        ShortcutManager shortcutManager = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
                shortcutManager = contex.getApplication().getSystemService(ShortcutManager.class);
            }
        }

        Intent dynamicHomeIntent = new Intent(contex, MainActivity.class);
        dynamicHomeIntent.setAction(Intent.ACTION_VIEW);

        Intent dynamicAboutIntent = new Intent(contex, AppInfoActivity.class);
        dynamicAboutIntent.setAction(Intent.ACTION_VIEW);

        //Create the ShortcutInfo object//


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {

            ShortcutInfo dynamicHomeShortcut = new ShortcutInfo.Builder(contex, "dynamic_shortcut_home")
                    //Define all the shortcut’s characteristics//
                    .setShortLabel(HOME_SHORT)
                    .setLongLabel(HOME_LONG)
                    .setIcon(Icon.createWithResource(contex, R.mipmap.ic_launcher))
                    .setIntent(dynamicHomeIntent)
                    .build();

            ShortcutInfo dynamicAboutShortcut = new ShortcutInfo.Builder(contex, "dynamic_shortcut_info")
                    //Define all the shortcut’s characteristics//
                    .setShortLabel(ABOUT_SHORT)
                    .setLongLabel(ABOUT_LONG)
                    .setIcon(Icon.createWithResource(contex, R.drawable.ic_launcher_foreground))
                    .setIntent(dynamicAboutIntent)
                    .build();

            if (shortcutManager != null) {
                if (createShortcut) {
                    //shortcutManager.setDynamicShortcuts(Collections.singletonList(dynamicHomeShortcut));
                    shortcutManager.setDynamicShortcuts(Arrays.asList(dynamicAboutShortcut, dynamicHomeShortcut));
                } else {
                    shortcutManager.removeDynamicShortcuts(Arrays.asList(dynamicAboutShortcut.getId(), dynamicHomeShortcut.getId()));
                }
            }
        }


        /*findViewById(R.id.changeShortcutLabel).setOnClickListener(new View.OnRecyclerItemClickListener() {
            @Override
            public void onClick(View v) {
                ShortcutInfo dynamicShortcut = new ShortcutInfo.Builder(HomeActivity.this, "dynamic_shortcut")
                        .setShortLabel("Label changed")
                        .build();

                shortcutManager.updateShortcuts(Arrays.asList(dynamicShortcut));
            }
        });*/
    }
}
