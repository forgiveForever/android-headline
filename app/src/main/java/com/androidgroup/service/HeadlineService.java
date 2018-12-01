package com.androidgroup.service;

import com.androidgroup.dao.HomeHeadlineDao;
import com.androidgroup.entity.Headline;

import java.util.List;

/**
 * Created by 刘丹丹 on 2018/10/23.
 */

public class HeadlineService {

    private HeadlineService(){}
    private  static HeadlineService headlineService;

    public static HeadlineService getHeadlineService(){
        if(headlineService==null){
            headlineService=new HeadlineService();
        }
        return headlineService;
    }

    public Headline getHeadlineInfo(String name){
        String sql="select * from headline where name = " + name;
        List<Headline> headlines= HomeHeadlineDao.getHomeHeadlineDao().executeQuery(sql);
        return headlines.get(0);
    }

    public List<Headline> showAllHeadlines(){
        String sql="select * from headline ";
        return HomeHeadlineDao.getHomeHeadlineDao().executeQuery(sql);
    }
}
