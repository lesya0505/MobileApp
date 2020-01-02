package com.lesenia.mobile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pharmacy {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("producer")
    @Expose
    private String producer;
    @SerializedName("components")
    @Expose
    private String components;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("photoUrl")
    @Expose
    private String photoUrl;

    public Pharmacy(final String name, final String category,
                    final String producer, final String components) {
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.price = price;
        this.components = components;
        this.photoUrl =photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getProducer() {
        return producer;
    }
    public String getComponents(){
        return components;
    }

    public String getPrice() {
        return price;
    }
    public String getPhotoUrl(){
        return photoUrl;
    }
}