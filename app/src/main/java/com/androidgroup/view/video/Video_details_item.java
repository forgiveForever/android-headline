package com.androidgroup.view.video;

/**
 * Created by 14457 on 2018/10/16.
 */

public class Video_details_item {
    private String name;
    private int imageId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Video_details_item(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public Video_details_item(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }
}
