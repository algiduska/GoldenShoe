package com.example.android.goldenshoe;

import android.media.Image;

/**
 * Demo shoes class to be potentially populated with all relevant info
 */
public class Shoes {

    private String name;
    private double price;
    //private String description;
    private int mainImage;
    //private boolean inStock;

    public Shoes(String name, double price, int mainImage){
        this.mainImage=mainImage;
        this.name=name;
        this.price=price;
    }

    public double getPrice() {
        return price;
    }

    public int getMainImage() {
        return mainImage;
    }

    public String getName() {
        return name;
    }


}
