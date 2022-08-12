package com.example.customcomponents.models.connectivity;


import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will be retrofit client.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */

final public class RetrofitClient {
    private static volatile RetrofitClient instance = null;
    private RepositoryApi client;
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    private RetrofitClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new LoggingInterceptor());
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client1 = new OkHttpClient.Builder()
                //.addInterceptor(new HeaderInterceptor())
                .addInterceptor(logging)
                //.authenticator(HeaderInterceptor.getBasicAuthenticator(USERNAME,PASSWORD))
                .retryOnConnectionFailure(true)
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit =
                new Retrofit.Builder().baseUrl("http://www.google.com") //BuildConfig.BASE_URL
                        .client(client1)
                        //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create()).build();
        client = retrofit.create(RepositoryApi.class);
    }


    public static RetrofitClient getInstance() {
        if (instance == null) {
            synchronized (RetrofitClient.class) {
                if (instance == null) {
                    instance = new RetrofitClient();
                }
            }
        }
        return instance;
    }

    public static RepositoryApi getMyCustomInstance(String url, Context context) {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new LoggingInterceptor());
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);


        CertificatePinner certificatePinner = new CertificatePinner.Builder()
                .add("*.example.com", "sha256/pin_certificate_key_here")
                .build();

        OkHttpClient clientPin = new OkHttpClient.Builder()
                .addInterceptor(new HeaderInterceptor(context))
                .addInterceptor(logging)
                //.authenticator(HeaderInterceptor.getBasicAuthenticator(USERNAME,PASSWORD))
                //.addInterceptor(new HttpLoggingInterceptor())
                .retryOnConnectionFailure(true)
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS)
                .certificatePinner(certificatePinner) // SSL Pinning for zensar.com domain

                .build();


        Retrofit retrofit =
                new Retrofit.Builder()
                        .baseUrl(url)
                        .client(clientPin)
                        //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                        //.addConverterFactory(ScalarsConverterFactory.create())
                        .addConverterFactory(GsonConverterFactory.create()).build();
        RepositoryApi temp = retrofit.create(RepositoryApi.class);
        return temp;
    }

    public RepositoryApi provideClient() {
        return client;
    }


}

