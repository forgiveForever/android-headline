package com.androidgroup.entity;

/**
 * Created by 刘丹丹 on 2018/10/23.
 */

public class Headline {

    private String name;
    private String sign;
    private String place;
    private String introduce;
    private String passage;
    private String content;

    public Headline(){}
    public Headline(String name,String sign,String place,String introduce,String passage,String content){
        this.name=name;
        this.sign=sign;
        this.place=place;
        this.introduce=introduce;
        this.passage=passage;
        this.content=content;
    }

    public void setName(String name){this.name=name;}
    public String getName(){return name;}

    public void setSign(String sign){this.sign=sign;}
    public String getSign(){return sign;}

    public void setPlace(String place){this.place=place;}
    public String getPlace(){return place;}

    public void setIntroduce(String introduce){this.introduce=introduce;}
    public String getIntroduce(){return introduce;}

    public void setPassage(String passage){this.passage=passage;}
    public String getPassage(){return passage;}

    public void setContent(String content){this.content=content;}
    public String getContent(){return content;}

}
