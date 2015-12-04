package com.frameworksystem.starwars.api;

import android.content.Context;

import com.frameworksystem.starwars.Constants;
import com.frameworksystem.starwars.StarWarsApp;
import com.frameworksystem.starwars.model.User;
import com.frameworksystem.starwars.ui.activity.RegisterActivity;
import com.frameworksystem.starwars.ui.fragment.LoginFragment;
import com.google.gson.Gson;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.MultipartBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.File;
import java.io.IOException;

/**
 * Created by felipe.arimateia on 12/1/2015.
 */
public class UserApi {

    private Context context;
    private OkHttpClient okHttpClient;

    public UserApi(Context context) {
        this.context = context;
        okHttpClient = StarWarsApp.getInstance(context).getOkHttpClient();
    }

    public void login(User user, final LoginFragment.OnLoginListener onLoginListener) {

        final Gson gson = new Gson();
        String json = gson.toJson(user);

        Request request = new Request.Builder()
                .url(Constants.API_LOGIN)
                .post(RequestBody.create(Constants.MEDIA_TYPE_JSON, json))
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (onLoginListener != null) {
                    onLoginListener.onLogin(null, 0);
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {

                if (onLoginListener == null) {
                    return;
                }

                if (response.code() == 200) {
                    User user = gson.fromJson(response.body().charStream(), User.class);
                    onLoginListener.onLogin(user, 0);
                }
                else {
                    onLoginListener.onLogin(null, response.code());
                }
            }
        });
    }

    public void register(User user, final LoginFragment.OnLoginListener onLoginListener) {

        final Gson gson = new Gson();
        String json = gson.toJson(user);

        Request request = new Request.Builder()
                .url(Constants.API_SIGNUP)
                .post(RequestBody.create(Constants.MEDIA_TYPE_JSON, json))
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (onLoginListener != null) {
                    onLoginListener.onLogin(null, 0);
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {

                if (onLoginListener == null) {
                    return;
                }

                if (response.code() == 200) {
                    User user = gson.fromJson(response.body().charStream(), User.class);
                    onLoginListener.onLogin(user, 0);
                }
                else {
                    onLoginListener.onLogin(null, response.code());
                }
            }
        });
    }

    public void uploadPhoto(String id, String path,
                            final RegisterActivity.OnUploadPhotoUser onUploadPhotoUser) {

        File file = new File(path);

        RequestBody requestBody = new MultipartBuilder()
                .type(MultipartBuilder.FORM)
                .addFormDataPart("file", file.getName(),
                        RequestBody.create(Constants.MEDIA_TYPE_IMAGE, file))
                .build();

        Request request = new Request.Builder()
                .url(String.format(Constants.API_UPLOAD_PHOTO_USER, id))
                .post(requestBody)
                .build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                if (onUploadPhotoUser != null) {
                    onUploadPhotoUser.onUpload(null);
                }
            }

            @Override
            public void onResponse(Response response) throws IOException {

                if (onUploadPhotoUser == null) {
                    return;
                }

                if (response.code() == 200) {
                    Gson gson = new Gson();
                    User user = gson.fromJson(response.body().charStream(), User.class);
                    onUploadPhotoUser.onUpload(user);
                }
                else {
                    onUploadPhotoUser.onUpload(null);
                }
            }
        });
    }
}
