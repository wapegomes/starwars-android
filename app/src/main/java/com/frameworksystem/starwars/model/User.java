package com.frameworksystem.starwars.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by felipets on 11/30/15.
 */
public class User implements Serializable{

    @SerializedName("_id")
    private String id;

    private String name;
    private String email;
    private String password;
    private String token;
    private String image;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
