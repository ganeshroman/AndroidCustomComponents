package com.example.customcomponents.models.connectivity;



import com.example.customcomponents.models.SessionData;

import java.util.ArrayList;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
//import rx.Observable;

public interface RepositoryApi {


    /*//@Headers("Content-Type: application/json")
    @POST("methodname")
    public Call<ExampleModelData> getSomeMethod(@Body String body, @Header("encryptedToken") String token);


    */

    /*TODO: remove headers from Parameters*//*
    @POST("someMethod")
    public Call<ExampleModelData> getSomeMethod(@HeaderMap Map<String, String> headers, @Body SomeRequest body, @Header("encryptedToken") String token);

    @POST("someMethodName")
    public Call<SomeData> getSomeExampleMethod(@Body SomeMethodRequest body);

  */

    /*@FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("someMethodName")
    public Call<SomeData> getLogin(@Field("userName") String username, @Field("password") String password, @Field("source") String source);

    //@FormUrlEncoded
    //@Headers("Content-Type: application/x-www-form-urlencoded")
    @GET("execSalesHomeDashboard")
    public Call<SomeData> getSomeMethod();

    @GET("execSalesHomeViewAllUpcomingPreviousMeetings")
    public Call<ArrayList<SomeModel>> getSomeMethod(@Query("query_param") String param1, @Query("query_param2") String param2);

*/


    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("someMethodName")
    public Call<SessionData> getLogin(@Field("userName") String username, @Field("password") String password, @Field("source") String source);





}
