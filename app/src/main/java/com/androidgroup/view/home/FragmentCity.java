package com.androidgroup.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.androidgroup.R;
import com.androidgroup.view.weather.WeatherActivity;

/**
 * Created by silence on 2018/10/14.
 */

public class FragmentCity extends Fragment {
    private TextView tvChange;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home_city,container,false);
        tvChange=(TextView)view.findViewById(R.id.tv_change_city);
        tvChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWeather=new Intent(getActivity(), WeatherActivity.class);
                getActivity().startActivity(goWeather);
            }
        });
        return  view;
    }
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentCity();
        return fragment;
    }
}
