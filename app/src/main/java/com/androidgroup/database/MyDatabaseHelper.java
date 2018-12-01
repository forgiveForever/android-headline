package com.androidgroup.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by silence on 2018/10/14.
 */

public class MyDatabaseHelper extends SQLiteOpenHelper {
    public static final String CREATE_NEWS="create table News("
            +"id integer primary key autoincrement,"
            +"pic text,"
            +"title text,"
            +"author text,"
            +"comment text,"
            +"article text"
            +"type integer)";
    public static final String CREATE_VIDEO="create table videos(id integer primary key autoincrement,title text,videoSource text,pic text,headimg text,author text)";
    public static final String CREATE_USER="create table user(id integer primary key autoincrement,name text,password text,email text)";
    private Context mContext;
    public MyDatabaseHelper(Context context){
        super(context,"my.db",null,1);
        mContext=context;
    }
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(CREATE_NEWS);
        sqLiteDatabase.execSQL(CREATE_VIDEO);
        sqLiteDatabase.execSQL(CREATE_USER);
    }
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){
        sqLiteDatabase.execSQL("drop table if exists News");
        sqLiteDatabase.execSQL("drop table if exists videos");
        sqLiteDatabase.execSQL("drop table if exists user");
        onCreate(sqLiteDatabase);
    }
}
