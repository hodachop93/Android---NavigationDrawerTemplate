package com.hodachop93.hohoda.api.usermanagement;

import com.hodachop93.hohoda.api.ApiClient;
import com.hodachop93.hohoda.model.Wallet;

import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.POST;


/**
 * Created by Hop on 07/03/2016.
 */
public class UserManagementApi {
    private static UserManagementApiInterface apiInterface;

    public static UserManagementApiInterface getInstance() {
        if (apiInterface == null) {
            apiInterface = ApiClient.getRetrofit().create(UserManagementApiInterface.class);
        }
        return apiInterface;
    }

    public interface UserManagementApiInterface {
        @POST("/user/registration")
        void register(@Body RegisterRequestBody body, Callback<Wallet> callback);
        @POST("/user/signin")
        void signIn(@Body SignInRequestBody body, Callback<Wallet> callback);
    }


}
