package com.hnnh.learnprogramming.androidarchitecture;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by hninNwayNwayhlaing on 8/25/2020.
 */
public class MyApp extends Application {
    private static MyApp INSTANCE;

    public static MyApp getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MyApp();
        }
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
    }
}
