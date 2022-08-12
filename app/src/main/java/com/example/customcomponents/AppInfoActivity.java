package com.example.customcomponents;

import android.os.Bundle;

import com.example.customcomponents.models.SessionData;
import com.example.customcomponents.models.connectivity.CustomCallback;
import com.example.customcomponents.models.connectivity.RetrofitClient;
import com.example.customcomponents.ui.base.BaseActivity;
import com.example.customcomponents.utils.LogUtil;

import retrofit2.Call;
import retrofit2.Response;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will be App Info Activity.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class AppInfoActivity extends BaseActivity {

    public static String TEMP_URL = "http://www.google.com";
    //public static String TEMP_URL=BuildConfig.BASE_URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_info);


    }


    private void sampleLoginCall(String username, String password) {


        if (username == null || username.length() <= 0 || password == null || password.length() <= 0) {
            showMessage("Invalid Username & password.");
            return;
        }

        RetrofitClient.getMyCustomInstance(TEMP_URL, this)
                .getLogin(username, password, "Test param").enqueue(new CustomCallback<SessionData>(this, false) {

                    @Override
                    public void onResponse(Call<SessionData> call, Response<SessionData> response) {
                        super.onResponse(call, response);

                        SessionData loginData = (SessionData) response.body();
                        if (loginData != null) {

                            loginData.saveSession(getApplicationContext());
                            showMessage("" + loginData.getUserId());
                            //openHomePage();

                        } else {
                            LogUtil.logcatD(" raw", "" + response.raw().toString());
                            //showMessage(login.getStatus());

                        }
                    }

                    @Override
                    public void onFailure(Call<SessionData> call, Throwable t) {
                        super.onFailure(call, t);

                        //showMessage(t.getMessage());

                        LogUtil.logcatE(" Msg", "" + t.getMessage());
                        LogUtil.logcatE(" URL", "" + call.request().toString());
                        LogUtil.logcatE(" Headers", "" + call.request().headers().toMultimap().toString());
                        LogUtil.logcatE(" Body", "" + call.request().body().contentType());
                    }
                });

    }


}