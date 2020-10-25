package com.example.restaurantsapplication.model;

import java.io.Serializable;

public class Image implements Serializable {
    private String imagePath;

    public Image(String image) {
        this.imagePath = image;
    }

    public String getImage() {
        return imagePath;
    }

    public void setImage(String image) {
        this.imagePath = image;
    }
}
