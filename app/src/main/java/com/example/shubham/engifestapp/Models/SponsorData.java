package com.example.shubham.engifestapp.Models;

/**
 * Created by mohitkumar on 08/01/17.
 */

public class SponsorData {

    String name;
    int imagesrc;

    public SponsorData(String name, int imagesrc){
        this.setName(name);
        this.setImagesrc(imagesrc);
    }

    public String getName() {
        return name;
    }

    public int getImagesrc() {
        return imagesrc;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setImagesrc(int imagesrc) {
        this.imagesrc = imagesrc;
    }
}
