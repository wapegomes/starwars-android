package com.frameworksystem.starwars;

import com.squareup.okhttp.MediaType;

/**
 * Created by felipe.arimateia on 12/1/2015.
 */
public interface Constants {

    String BASE_URL = "http://arimateia.info:3005";
    String API_LOGIN = Constants.BASE_URL + "/users/login";
    String API_SIGNUP = Constants.BASE_URL + "/users/signup";
    String API_DROIDS = Constants.BASE_URL + "/droids";
    String BASE_URL_IMAGE = Constants.BASE_URL + "/images/%s";
    String API_UPLOAD_PHOTO_USER = BASE_URL + "/users/uploadPhoto/%s";

    MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json");
    MediaType MEDIA_TYPE_IMAGE = MediaType.parse("image/*");
}
