package com.androidgroup;

import com.androidgroup.entity.NewInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by silence on 2018/10/7.
 */

public class JsonParse {
    public static List<NewInfo> getNewInfo(String json){
        Gson gson=new Gson();
        Type listType=new TypeToken<List<NewInfo>>(){}.getType();
        List<NewInfo> newInfos=gson.fromJson(json,listType);
        return newInfos;
    }
}
