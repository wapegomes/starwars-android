package com.frameworksystem.starwars.api;

import android.content.Context;

import com.frameworksystem.starwars.Constants;
import com.frameworksystem.starwars.model.Droid;
import com.frameworksystem.starwars.model.Film;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by felipe.arimateia on 12/3/2015.
 */
public class FilmsApi extends BaseApi{

    public FilmsApi(Context context) {
        super(context);
    }

    public void droids(final OnFilmsListener onFilmsListener){

        Request request = new Request.Builder()
                .url(Constants.API_FILMS)
                .get().build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (onFilmsListener != null) {
                    onFilmsListener.onFilms(null, 500);
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {

                if (onFilmsListener == null) {
                    return;
                }

               if (response.isSuccessful()) {
                   Gson gson = new Gson();
                   List<Film> droids = gson.fromJson(response.body().charStream(),
                           new TypeToken<List<Film>>(){}.getType());

                   onFilmsListener.onFilms(droids, 0);
               }
                else {
                   onFilmsListener.onFilms(null, response.code());
               }
            }
        });
    }

    public interface OnFilmsListener {
        void onFilms(List<Film> films, int errorCode);
    }
}
