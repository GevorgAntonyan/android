package com.example.astghik.searchexample;

import android.app.ActivityManager;

public class User {
    String imageUrl;
    String name;
    String description;
    String email;
    String phonNumber;
    Float rating;

    public User(String imageUrl, String name, String description, String email, String phonNumber, Float rating) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.description = description;
        this.email = email;
        this.phonNumber = phonNumber;
        this.rating = rating;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }


}
