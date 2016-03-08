package com.hodachop93.hohoda.api;

import android.os.Build;

import com.hodachop93.hohoda.HohodaApplication;
import com.hodachop93.hohoda.common.AppReferences;
import com.hodachop93.hohoda.utils.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.TimeZone;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Hop on 08/03/2016.
 */
public class ApiClient {
    private static Retrofit retrofit;

    private static String BASE_URL = "http://10.13.5.71:8080/api/";

    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

            // set your desired log level
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            // add your other interceptors …
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("sessionID", "")
                            .header("productVersion", "")
                            .header("applicationVersion", Build.VERSION.CODENAME)
                            .header("deviceFingerprint", getDeviceFingerPrint())
                            .header("timestamp", String.valueOf(System.currentTimeMillis()))
                            .header("timezone", TimeZone.getDefault().getID())
                            .header("locale", Utils.getUserCountry(HohodaApplication.getInstance()))
                            .header("Content-Type", "application/json")
                            .header("deviceTokenID", AppReferences.getDeviceToken())
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });
            // add logging as last interceptor
            httpClient.addInterceptor(logging);  // <-- this is the important line!

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient.build())
                    .build();
        }
        return retrofit;
    }

    private static String getDeviceFingerPrint() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("oem", "");
            jsonObject.put("modelName", "");
            jsonObject.put("modelNo", "");
            jsonObject.put("os", "Android");
            jsonObject.put("osVersion", Build.VERSION.CODENAME);
            jsonObject.put("handsetId", "");
            jsonObject.put("iccID", "");
            jsonObject.put("screenHeight", "");
            jsonObject.put("screenWidth", "");

            return jsonObject.toString();

        } catch (JSONException e) {
            return null;
        }
    }
}
