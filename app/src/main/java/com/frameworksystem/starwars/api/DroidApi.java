package com.frameworksystem.starwars.api;

import android.content.Context;

import com.frameworksystem.starwars.Constants;
import com.frameworksystem.starwars.model.Droid;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by felipe.arimateia on 12/3/2015.
 */
public class DroidApi extends BaseApi{

    public DroidApi(Context context) {
        super(context);
    }

    public void droids(final OnDroidsListener onDroidsListener){

        Request request = new Request.Builder()
                .url(Constants.API_DROIDS)
                .get().build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (onDroidsListener != null) {
                    onDroidsListener.onDroids(null, 500);
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {

                if (onDroidsListener == null) {
                    return;
                }

               if (response.isSuccessful()) {
                   Gson gson = new Gson();
                   List<Droid> droids = gson.fromJson(response.body().charStream(),
                           new TypeToken<List<Droid>>(){}.getType());

                   onDroidsListener.onDroids(droids, 0);
               }
                else {
                   onDroidsListener.onDroids(null, response.code());
               }
            }
        });
    }


    public interface OnDroidsListener {
        void onDroids(List<Droid> drois, int errorCode);
    }
}
