package com.example.customcomponents.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.customcomponents.R;
import com.example.customcomponents.interfaces.DialogListener;
import com.example.customcomponents.ui.base.BaseDialogFragment;
import com.google.android.material.snackbar.Snackbar;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This contains helper method.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class Helper {

    //public static final Helper INSTANCE;

    private Helper() {

    }

    /*static {
        Helper var0 = new Helper();
        INSTANCE = var0;
    }*/

    public static void showMessage(Activity context, String msg) {

        hideKeyboard(context);

        Snackbar snack = Snackbar.make(context.getWindow().getDecorView().getRootView(), "" + msg, Snackbar.LENGTH_SHORT);
        View view = snack.getView();

        /*FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;*/
        final ViewGroup.LayoutParams params = snack.getView().getLayoutParams();
        if (params instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
        } else if (params instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
        } else if (params instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_START);
            //lp.addRule(RelativeLayout.ALIGN_PARENT_START);
        } else if (params instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
            //lp.addRule(RelativeLayout.ALIGN_PARENT_START);
        } else {
            ((FrameLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
        }


        int topBar = 50;
        int left = 8;
        try {
            topBar = getNavigationBarHeight(context, Configuration.ORIENTATION_PORTRAIT);
        } catch (Exception ex) {
            ex.printStackTrace();
            topBar = 50;
        }

        topBar = topBar + Helper.dpToPx(left, context);

        ((ViewGroup.MarginLayoutParams) params).setMargins(
                Helper.dpToPx(left, context),
                ((ViewGroup.MarginLayoutParams) params).topMargin,
                Helper.dpToPx(left, context),
                topBar
                //Utils.dpToPx(50,context)
        );

        //params.setMargins(leftMargin, topMargin, rightMargin, bottomBar.height);

        /*view.setBackgroundColor(ContextCompat.getColor(context, R.color.color_blue_light));
        TextView textView = (TextView) view.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(context, R.color.color_white));*/

        view.setLayoutParams(params);
        snack.show();
    }


    public static void showMessageAction(Activity context, String msg, String action_text, View.OnClickListener action_listener) {
        hideKeyboard(context);

        Snackbar snack = Snackbar.make(context.getWindow().getDecorView().getRootView(), "" + msg, Snackbar.LENGTH_INDEFINITE);
        View view = snack.getView();

        /*FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
        params.gravity = Gravity.TOP;*/
        final ViewGroup.LayoutParams params = snack.getView().getLayoutParams();
        if (params instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
        } else if (params instanceof LinearLayout.LayoutParams) {
            ((LinearLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
        } else if (params instanceof RelativeLayout.LayoutParams) {
            ((RelativeLayout.LayoutParams) params).addRule(RelativeLayout.ALIGN_PARENT_START);
            //lp.addRule(RelativeLayout.ALIGN_PARENT_START);
        } else if (params instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
            //lp.addRule(RelativeLayout.ALIGN_PARENT_START);
        } else {
            ((FrameLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
        }


        int topBar = 50;
        int left = 8;
        try {
            topBar = getNavigationBarHeight(context, Configuration.ORIENTATION_PORTRAIT);
        } catch (Exception ex) {
            ex.printStackTrace();
            topBar = 50;
        }

        topBar = topBar + Helper.dpToPx(left, context);

        ((ViewGroup.MarginLayoutParams) params).setMargins(
                Helper.dpToPx(left, context),
                ((ViewGroup.MarginLayoutParams) params).topMargin,
                Helper.dpToPx(left, context),
                topBar
                //Utils.dpToPx(50,context)
        );

        //params.setMargins(leftMargin, topMargin, rightMargin, bottomBar.height);

        /*view.setBackgroundColor(ContextCompat.getColor(context, R.color.color_blue_light));
        TextView textView = (TextView) view.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(context, R.color.color_white));*/

        view.setLayoutParams(params);
        snack.setAction(action_text, action_listener);
        snack.show();
    }


    public static void addFragment(AppCompatActivity context, Fragment fragment) {
        //clearBackstack(context);
        FragmentTransaction transaction = ((AppCompatActivity) context).getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layDialogContainer, fragment); // Some Container to add fragment
        transaction.addToBackStack(null);
        transaction.commit();
    }


    public static void startDialogFragment(AppCompatActivity context, BaseDialogFragment dialogFragment, Bundle bundle, DialogListener listener) {
        AppCompatActivity activity = ((AppCompatActivity) context);
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();

        dialogFragment.setListener(listener);
        dialogFragment.setArguments(bundle);

        Fragment prev = activity.getSupportFragmentManager().findFragmentByTag(BaseDialogFragment.PARAM_BUNDLE_DIALOG_TAG);
        if (prev != null) {
            ft.remove(prev);
        }
        ft.addToBackStack(null);

        dialogFragment.show(ft, BaseDialogFragment.PARAM_BUNDLE_DIALOG_TAG);
    }


    public static void clearBackstack(AppCompatActivity context) {
        FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
        if (manager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry first = manager.getBackStackEntryAt(0);
            manager.popBackStack(first.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }


    private static int getNavigationBarHeight(Context context, int orientation) {
        Resources resources = context.getResources();

        int id = resources.getIdentifier(
                orientation == Configuration.ORIENTATION_PORTRAIT ? "navigation_bar_height" : "navigation_bar_height_landscape",
                "dimen", "android");
        if (id > 0) {
            return resources.getDimensionPixelSize(id);
        }
        return 0;
    }


    public static final int dpToPx(float dp, Context context) {
        //Intrinsics.checkParameterIsNotNull(context, "context");
        Resources resources = context.getResources();
        //Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return dpToPx(dp, resources);
    }

    private static final int dpToPx(float dp, Resources resources) {
        float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
        return (int) px;
    }

    // Under implementation.
    public static void getLoadGlide(Context context, View view, String url) {

    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        View view = activity.getCurrentFocus();
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
