package com.androidgroup.entity;

/**
 * Created by silence on 2018/10/21.
 */

public class VideoInfo {
    private String title;
    private String headimg;
    private String author;
    private String videoSource;
    private String picSource;
    public VideoInfo(String title,String videoSource,String picSource,String headimg,String author){
        this.title=title;
        this.headimg=headimg;
        this.author=author;
        this.videoSource=videoSource;
        this.picSource=picSource;
    }
    public String getVideoSource() {
        return videoSource;
    }

    public void setVideoSource(String videoSource) {
        this.videoSource = videoSource;
    }

    public String getPicSource() {
        return picSource;
    }

    public void setPicSource(String picSource) {
        this.picSource = picSource;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
