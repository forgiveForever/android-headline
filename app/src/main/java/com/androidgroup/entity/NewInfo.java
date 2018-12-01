package com.androidgroup.entity;

/**
 * Created by silence on 2018/10/5.
 */

public class NewInfo{

    private int id;
    private String picSource;
    private String title;
    private String author;
    //private int type;
    private String comment;
    private String article;
    public NewInfo(String title,String icon, String author, String comment, String article){
        this.id=id;
        this.picSource=icon;
        this.title=title;
        this.author=author;
        //this.type=type;
        this.comment=comment;
        this.article=article;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getPicSource() { return picSource;}

    public void setPicSource(String icon) {
        this.picSource = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

//    public int getType() {
//        return type;
//    }
//
//    public void setType(int type) {
//        this.type = type;
//    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
