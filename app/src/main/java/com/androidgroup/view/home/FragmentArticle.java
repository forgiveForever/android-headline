package com.androidgroup.view.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidgroup.R;

/**
 * Created by silence on 2018/10/22.
 */

public class FragmentArticle extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home_content,container,false);
        return  view;
    }
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentCity();
        return fragment;
    }

}
