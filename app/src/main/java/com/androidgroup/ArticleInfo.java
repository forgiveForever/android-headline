package com.androidgroup;

/**
 * Created by silence on 2018/10/21.
 */

public class ArticleInfo {
    private int id;
    private String article;
    public ArticleInfo(int id,String article){
        this.id=id;
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
}
