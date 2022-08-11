package com.example.customcomponents.models.connectivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.customcomponents.models.StdResponse;
import com.example.customcomponents.utils.Helper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CustomCallback<T> implements Callback<T> {

    private ProgressDialog mProgressDialog;
    private Context context;
    private Boolean blindMsg = false;

    public CustomCallback(Context context, Boolean blindMsg) {
        try {
            this.context = context;
            this.blindMsg = blindMsg;
            mProgressDialog = new ProgressDialog(context);
            /*((Activity) context).getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                    WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);*/
            mProgressDialog.setIndeterminate(true);
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setCanceledOnTouchOutside(false);
            mProgressDialog.setCancelable(false);

            mProgressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
                @Override
                public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                    // Prevent dialog close on back press button
                    return keyCode == KeyEvent.KEYCODE_BACK;
                }
            });

            mProgressDialog.show();


        /*final ProgressDialog progress = new ProgressDialog(context);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        progress.show();*/
            ProgressBar progressbar = (ProgressBar) mProgressDialog.findViewById(android.R.id.progress);
            //progressbar.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(context, R.color.color_dot_blue_dark), android.graphics.PorterDuff.Mode.SRC_IN);

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        try {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
                ((Activity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /*

        TODO: Error Code Messages handle and session timeout

        */
        try {
            StdResponse res = (StdResponse) response.body();
            if (res != null)
                if (res.getStatusCode().trim().equalsIgnoreCase("4")) {
                    if (!blindMsg)
                        Helper.showMessage((Activity) context, "No Data Found!");
                } else if (res.getStatusCode().trim().equalsIgnoreCase("0")) {
                    // here nothing to do, it will process respective webservice
                } /*else if (res.getStatusCode().trim().equalsIgnoreCase(Integer.toString(USER_VALIDATION_CODE))

                ) {

                    // Logout user from app
                    *//*UserInfo user1 = new UserInfo();
                    user1.logoutSession(context);
                    Intent intentLogin = new Intent(context, LoginActivity.class);
                    context.startActivity(intentLogin);
                    ((Activity) context).finish();*//*

                } else if (res.getStatusCode().trim().equalsIgnoreCase(Integer.toString(LOGIN_INVALID))) {

                    if (!(((Activity) context) instanceof LoginActivity)) { // Exclude Login Activity for logout
                        SessionData user1 = new SessionData();
                        user1.logoutSession(context);
                        Intent intentLogin = new Intent(context, LoginActivity.class);
                        context.startActivity(intentLogin);
                        ((Activity) context).finish();
                    }
                }*/ else {
                    if (!blindMsg)
                    Helper.showMessage((Activity) context, "" + res.getStatus());
                }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        try {
            if (mProgressDialog.isShowing()) {
                mProgressDialog.dismiss();
                ((Activity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
            }

            if (!blindMsg)
                Helper.showMessage((Activity) context, t.getMessage());

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
