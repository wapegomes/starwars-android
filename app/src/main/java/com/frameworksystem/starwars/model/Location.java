package com.frameworksystem.starwars.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by felipe.arimateia on 12/8/2015.
 */
public class Location implements Serializable {

    @SerializedName("_id")
    private String id;
    private String title;
    private String description;
    private String image;
    private double latitude;
    private double longitude;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
