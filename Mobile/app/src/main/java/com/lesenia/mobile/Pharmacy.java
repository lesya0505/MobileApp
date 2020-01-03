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
                    final String producer, final String price,
                    final String components, final String photoUrl) {
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.price = price;
        this.components = components;
        this.photoUrl =photoUrl;
    }

    public Pharmacy(String name, String category, String producer, String price) {
        this.name = name;
        this.category = category;
        this.producer = producer;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }
}