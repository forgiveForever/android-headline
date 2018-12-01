package com.androidgroup.dao;

import com.androidgroup.entity.Headline;
import com.androidgroup.util.MysqlDBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘丹丹 on 2018/10/23.
 */

public class HomeHeadlineDao {

    private static HomeHeadlineDao homeHeadlineDao;

    public static HomeHeadlineDao getHomeHeadlineDao(){
        if(homeHeadlineDao==null){
            homeHeadlineDao=new HomeHeadlineDao();
        }
        return homeHeadlineDao;
    }

    public boolean executeUpdate(String sql){
        Connection connection= MysqlDBUtil.open();
        Statement statement=null;
        try {
            statement=connection.createStatement();
            int success=statement.executeUpdate(sql);
            if (success<=0) {
               return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {// 关闭数据库及statement的连接
            try {
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public List<Headline> executeQuery(String sql){
        List<Headline> headlines=new ArrayList<>();
        Connection connection=MysqlDBUtil.open();
        Statement statement=null;
        try {
            statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                Headline headline=new Headline();
                headline.setName(resultSet.getNString("name"));
                headline.setSign(resultSet.getNString("sign"));
                headline.setIntroduce(resultSet.getNString("introduce"));
                headline.setPlace(resultSet.getNString("place"));
                headline.setContent(resultSet.getNString("content"));
                headline.setPassage(resultSet.getNString("passage"));
                headlines.add(headline);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {// 关闭数据库及statement的连接
            try {
                if(statement != null){
                    statement.close();
                }
                if(connection != null){
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return headlines;
    }
}
