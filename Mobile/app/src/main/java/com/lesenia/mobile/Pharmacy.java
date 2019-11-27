package com.lesenia.mobile;

public class Pharmacy {

    private final String name;
    private final String category;
    private final String packaging;
    private final String producer;
    private final String price;
    private final String components;
    private final String photoUrl;

    public Pharmacy(final String name, final String category, final String packaging,
                    final String producer, final String price, final String components, final String photoUrl) {
        this.name = name;
        this.category = category;
        this.packaging = packaging;
        this.producer = producer;
        this.price = price;
        this.components = components;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPackaging() {
        return packaging;
    }

    public String getProducer() {
        return producer;
    }

    public String getPrice() {
        return price;
    }

    public String getComponents() {
        return components;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}