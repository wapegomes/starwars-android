package com.frameworksystem.starwars.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by felipe.arimateia on 12/3/2015.
 */
public class Characters {

    @SerializedName("_id")
    private String id;
    private String name;
    private String image;
}
