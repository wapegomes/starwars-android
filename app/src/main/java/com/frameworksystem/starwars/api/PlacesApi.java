package com.frameworksystem.starwars.api;

import android.content.Context;

import com.frameworksystem.starwars.Constants;
import com.frameworksystem.starwars.model.Place;
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
public class PlacesApi extends BaseApi{

    public PlacesApi(Context context) {
        super(context);
    }

    public void locations(final OnPlacesListener onPlacesListener){

        Request request = new Request.Builder()
                .url(Constants.API_LOCATIONS)
                .get().build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (onPlacesListener != null) {
                    onPlacesListener.onPlaces(null, 500);
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {

                if (onPlacesListener == null) {
                    return;
                }

               if (response.isSuccessful()) {
                   Gson gson = new Gson();
                   List<Place> places = gson.fromJson(response.body().charStream(),
                           new TypeToken<List<Place>>(){}.getType());

                   onPlacesListener.onPlaces(places, 0);
               }
                else {
                   onPlacesListener.onPlaces(null, response.code());
               }
            }
        });
    }

    public interface OnPlacesListener {
        void onPlaces(List<Place> places, int errorCode);
    }
}
