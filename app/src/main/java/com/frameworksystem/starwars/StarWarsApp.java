package com.frameworksystem.starwars;

import android.app.Application;
import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by felipets on 11/16/15.
 */
public class StarWarsApp extends Application {

    private OkHttpClient okHttpClient;
    private final int cacheSize = 10 * 1024 * 1024; // 10 MiB

    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG){
            Stetho.initializeWithDefaults(this);
        }

        createOkHttpClient();
    }

    private void createOkHttpClient() {
        Cache cache = new Cache(getCacheDir(), cacheSize);

        okHttpClient = new OkHttpClient();
        okHttpClient.setCache(cache);

        if (BuildConfig.DEBUG) {
            okHttpClient.interceptors().add(new StethoInterceptor());
        }
    }

    public static StarWarsApp getInstance(Context context) {
        return (StarWarsApp)context.getApplicationContext();
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }
}
