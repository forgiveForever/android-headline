package com.androidgroup.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
/**
 * Created by silence on 2018/10/18.
 */

public class FragmentLittleHeadline extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home_headline,container,false);
        ImageView iv=(ImageView)view.findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyApplication.getContext(), HomeHeadLineIntroduce.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentLittleHeadline();
        return fragment;
    }

}
