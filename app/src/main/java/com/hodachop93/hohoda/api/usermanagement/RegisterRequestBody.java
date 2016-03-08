package com.hodachop93.hohoda.api.usermanagement;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Hop on 08/03/2016.
 */
public class RegisterRequestBody {
    @SerializedName("user_name")
    private String userName;
    private String email;
    private String password;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
