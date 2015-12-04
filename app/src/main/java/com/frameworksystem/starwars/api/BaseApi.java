package com.frameworksystem.starwars.api;

import android.content.Context;

import com.frameworksystem.starwars.StarWarsApp;
import com.squareup.okhttp.OkHttpClient;

/**
 * Created by felipe.arimateia on 12/3/2015.
 */
public class BaseApi {

    protected final Context context;
    protected final OkHttpClient okHttpClient;

    public BaseApi(Context context) {
        this.context = context;
        okHttpClient = StarWarsApp.getInstance(context).getOkHttpClient();
    }
}
