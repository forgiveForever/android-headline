package com.androidgroup.view.Xigua;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidgroup.view.home.HomeHeadLineIntroduce;
import com.androidgroup.R;

/**
 * Created by silence on 2018/10/19.
 */

public class FragmentVariety extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.home_headline,container,false);
        /*跳转到home_headline_introduce界面*/
        ImageView iv=(ImageView) view.findViewById(R.id.iv);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HomeHeadLineIntroduce.class);
                startActivity(intent);
            }
        });
        return view;
    }
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentVariety();
        return fragment;
    }


}
