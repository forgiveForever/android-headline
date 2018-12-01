package com.androidgroup.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.androidgroup.entity.User;

/**
 * Created by silence on 2018/10/31.
 */

public class UserService {//通过userService对数据库进行操作
    private MyDatabaseHelper dbHelper;
    public UserService(Context context){
        dbHelper=new MyDatabaseHelper(context);
    }

    //登录用
    public boolean login(String username,String password){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="select * from user where name=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    //注册用
    public boolean register(String name2,String pass2){
        SQLiteDatabase sdb=dbHelper.getReadableDatabase();
        String sql="insert into user(name,password) values(?,?)";
        Object obj[]={name2,pass2};
        sdb.execSQL(sql, obj);
        return true;
    }
    public boolean insert(String username,String password){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String sql="insert into user(name,password) values(?,?)";
        Object object[]={username,password};
        db.execSQL(sql,object);
        return true;
    }
}

