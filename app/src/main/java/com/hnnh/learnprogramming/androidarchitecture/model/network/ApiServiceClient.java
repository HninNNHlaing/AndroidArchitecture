package com.hnnh.learnprogramming.androidarchitecture.model.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hnnh.learnprogramming.androidarchitecture.BuildConfig;
import com.hnnh.learnprogramming.androidarchitecture.helper.constant.AppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hninNwayNwayhlaing on 8/25/2020.
 */
public class ApiServiceClient {
    public static Retrofit initRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(BuildConfig.DEBUG ? interceptor.setLevel(HttpLoggingInterceptor.Level.BODY) : interceptor.setLevel(HttpLoggingInterceptor.Level.NONE))
                .connectTimeout(AppConstants.TIME_OUT_SECOND, TimeUnit.SECONDS)
                .readTimeout(AppConstants.TIME_OUT_SECOND, TimeUnit.SECONDS)
                .writeTimeout(AppConstants.TIME_OUT_SECOND, TimeUnit.SECONDS)
                .build();

        return new retrofit2.Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
