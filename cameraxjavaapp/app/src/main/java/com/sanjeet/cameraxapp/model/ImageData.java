package com.sanjeet.cameraxapp.model;

/**
 * Created by SANJEET KUMAR on 23,February,2021, sk698166@gmail.com
 **/
public class ImageData {
    String imageUrl;
    String ImageName;
    String imageDate;

    public ImageData() {
    }

    public ImageData(String ImageName, String imageDate, String imageUrl) {
        this.imageUrl = imageUrl;
        this.ImageName = ImageName;
        this.imageDate = imageDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageName() {
        return ImageName;
    }

    public void setImageName(String imageName) {
        ImageName = imageName;
    }

    public String getImageDate() {
        return imageDate;
    }

    public void setImageDate(String imageDate) {
        this.imageDate = imageDate;
    }
}
