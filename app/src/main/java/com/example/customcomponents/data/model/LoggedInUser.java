package com.example.customcomponents.data.model;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will help to understand easily.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class LoggedInUser {

    private String userId;
    private String displayName;

    public LoggedInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}