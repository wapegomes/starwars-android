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
    String API_FILMS = BASE_URL + "/films";
    String BASE_URL_IMAGE = Constants.BASE_URL + "/images/%s";
    String API_UPLOAD_PHOTO_USER = BASE_URL + "/users/uploadPhoto/%s";

    MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json");
    MediaType MEDIA_TYPE_IMAGE = MediaType.parse("image/jpg");

    String DDL_DROIDS = "CREATE TABLE [droids] (\n" +
            "  [id] TEXT, \n" +
            "  [name] VARCHAR(100), \n" +
            "  [description] TEXT, \n" +
            "  [link] TEXT, \n" +
            "  [image] TEXT, \n" +
            "  CONSTRAINT [] PRIMARY KEY ([id]));\n";

    String DDL_FILMS = "CREATE TABLE [films] (\n" +
            "  [id] TEXT NOT NULL, \n" +
            "  [name] VARCHAR(100), \n" +
            "  [description] TEXT, \n" +
            "  [year] INT, \n" +
            "  [image] TEXT, \n" +
            "  [link] TEXT, \n" +
            "  CONSTRAINT [] PRIMARY KEY ([id]));";

}
