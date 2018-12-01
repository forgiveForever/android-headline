package com.androidgroup.view.home;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidgroup.R;

/**
 * Created by silence on 2018/10/10.
 */

public class FragmentGuanzhu extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home_guanzhu,container,false);
        TabLayout tabLayout=(TabLayout)view.findViewById(R.id.tabLayout_guanzhu);
        for(int i=0;i<6;i++){
            TabLayout.Tab tab=tabLayout.newTab();
            tab.setText("新华社"+i);
            tab.setIcon(R.drawable.xinhua_img);
            tabLayout.addTab(tab);
        }
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setSelectedTabIndicatorHeight(0);
        return view;
    }

    public static Fragment newsInstance(){
        Fragment fragment=new FragmentGuanzhu();
        return fragment;
    }
}
