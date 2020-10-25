package com.example.restaurantsapplication.model;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("imagePath")
    private String imagePath;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    public Item(String icon, String title, String subtitle) {
        this.imagePath = icon;
        this.name = title;
        this.description = subtitle;


    }

    public String getIcon() {
        return imagePath;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }



    public void setIcon(String icon) {
        this.imagePath = icon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}

