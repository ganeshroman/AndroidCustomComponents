package com.example.customcomponents.models;

import com.example.customcomponents.BuildConfig;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @param @nullable Temp    Explanation
 * @author Ganesh
 * <p>
 * This will help be standard request.
 * </p>
 * Created by Ganesh Roman on 12,August,2022
 */
public class StdRequest {

    @Expose
    @SerializedName("someInputFieldName1")
    private String someInput2 = "10";

    @Expose
    @SerializedName("version")
    private String version = BuildConfig.VERSION_NAME;

    @Expose
    @SerializedName("someInputFieldName2")
    private String someInput = "0";


    /*@Expose
    @SerializedName("encryptedToken")*/
    private String headerToken = "";


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public String getHeaderToken() {
        return headerToken;
    }

    public void setHeaderToken(String headerToken) {
        this.headerToken = headerToken;
    }

    public String getSomeInput2() {
        return someInput2;
    }

    public void setSomeInput2(String someInput2) {
        this.someInput2 = someInput2;
    }

    public String getSomeInput() {
        return someInput;
    }

    public void setSomeInput(String someInput) {
        this.someInput = someInput;
    }
}
