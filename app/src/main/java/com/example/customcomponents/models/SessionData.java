package com.example.customcomponents.models;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SessionData extends StdResponse{

    private String LOGIN_PREF = "Login_pref";
    private String TOKEN = "tken_pref";
    private String FIRST_NAME = "first_name_pref";
    private String LAST_NAME = "last_name_pref";
    private String USER_PIC_URL = "user_pci_pref";

    @Expose
    @SerializedName("profile_pic")
    private
    String profilePic = new String();

    @Expose
    @SerializedName("userId")
    private String userId = new String();

    @Expose
    @SerializedName("emailAddress")
    private String emailAddress = new String();

    @Expose
    @SerializedName("accessToken")
    private String accessToken = new String();

    @Expose
    @SerializedName("firstName")
    private String firstName = new String();

    @Expose
    @SerializedName("lastName")
    private String lastName = new String();


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void saveSession(Context context) {
        SharedPreferences pref = context.getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.putString(FIRST_NAME, getFirstName());
        editor.putString(LAST_NAME, getLastName());
        editor.putString(USER_PIC_URL, getProfilePic());
        editor.putString(TOKEN, getAccessToken());

        editor.commit();
    }

    public void loadSession(Context context) {
        try {
            SharedPreferences pref = context.getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE); // 0 - for private mode
            //setUserId(pref.getString(USER_ID,"id"));
            setFirstName(pref.getString(FIRST_NAME, "first name"));
            setLastName(pref.getString(LAST_NAME, "last name"));
            setProfilePic(pref.getString(USER_PIC_URL, "pic"));
            setAccessToken(pref.getString(TOKEN, ""));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public String instantToken(Context context) {
        SharedPreferences pref = context.getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE); // 0 - for private mode

        setAccessToken(pref.getString(TOKEN, ""));

        return getAccessToken();
    }

    public void logoutSession(Context context) {
        SharedPreferences pref = context.getSharedPreferences(LOGIN_PREF, Context.MODE_PRIVATE); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

        editor.clear();
        editor.commit();
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }


}

