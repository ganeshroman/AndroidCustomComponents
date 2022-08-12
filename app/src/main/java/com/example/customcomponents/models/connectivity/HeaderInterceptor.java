package com.example.customcomponents.models.connectivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.customcomponents.models.SessionData;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * Custom Header Interceptor for the Retrofit.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class HeaderInterceptor implements Interceptor {

    Context context = null;
    private boolean isNetworkActive;

    public HeaderInterceptor(Context contex) {
        context = contex;
    }

    public HeaderInterceptor() {
    }

    @Override
    public Response intercept(Chain chain)
            throws IOException {

        if (!isOnline()) {
            throw new NoConnectivityException();
        }


        Request request = chain.request();

        if (context != null) {

            SessionData data = new SessionData();
            data.loadSession(context);

            request = request.newBuilder()
                    //.addHeader("appid", "every_build_version") //
                    //.addHeader("userID", "user_123")
                    //.addHeader("skey/token", "token")
                    //.addHeader("deviceplatform", "android")

                    .headers(getJsonHeader(data.getAccessToken()))
                    //.addHeader("encryptedToken","2b180eb11ea4b2")
                    //.addHeader("encryptedToken", "" + user.instantToken(context))

                    /*.removeHeader("User-Agent")
                    .addHeader("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:38.0) Gecko/20100101 Firefox/38.0") */
                    .build();
        } else {
            request = request.newBuilder()
                    .headers(getJsonHeader(""))
                    .build();
        }

        Response response = chain.proceed(request);

        return response;
    }


    public boolean isOnline() {
        if (context != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = connectivityManager.getActiveNetworkInfo();
            return (netInfo != null && netInfo.isConnected());
        }

        return false;
    }

    private static Headers getJsonHeader(String authToken) {
        Headers.Builder builder = new Headers.Builder();
        builder.add("X-Requested-With", "com.example.testingpackage");
        builder.add("accessToken", "" + authToken);
        // builder.add("X-Requested-With", "com.example.testingpackage");
        // builder.add("Content-Type", "application/json");
        // builder.add("Accept", "application/json");
        if (authToken != null && !authToken.isEmpty()) {
            builder.add("X-MY-Auth", authToken);
        }
        return builder.build();
    }

    /*protected static Authenticator getBasicAuthenticator(final String userName, final String password) {
        return (route, response) -> {
            String credential = Credentials.basic(userName, childserver.example.com);
            return response.request().newBuilder().header("Authorization", credential).build();
        };
    }*/
}