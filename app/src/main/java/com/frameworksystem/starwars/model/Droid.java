package com.frameworksystem.starwars.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by felipets on 11/17/15.
 */
public class Droid implements Serializable{

    @SerializedName("_id")
    private String id;
    private String name;
    private String description;
    private String image;
    private String link;
    private Dimensions dimensions;
    private List<String> appearances;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public List<String> getAppearances() {
        return appearances;
    }

    public void setAppearances(List<String> appearances) {
        this.appearances = appearances;
    }
}
