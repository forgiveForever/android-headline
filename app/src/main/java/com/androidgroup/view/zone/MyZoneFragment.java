package com.androidgroup.view.zone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.androidgroup.bottomFragment.MineFragment;
import com.androidgroup.view.my_center.my_center_activity;
import com.androidgroup.view.my_center.my_feedback_feedback;
import com.androidgroup.view.system.LoginActivity;

/**
 * Created by silence on 2018/10/17.
 */

//没有用,改用mineFragment
public class MyZoneFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View view=inflater.inflate(R.layout.myzone,container,false);
        ImageView toLogin=(ImageView)view.findViewById(R.id.toRight);
        ImageView wallet=(ImageView)view.findViewById(R.id.my_wallet);
        ImageView feedback=(ImageView)view.findViewById(R.id.iv_feedback);
        if(savedInstanceState!=null){
            getChildFragmentManager().beginTransaction().replace(R.id.ll_container_myzone, MineFragment.newInstance()).commit();
        }
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),my_center_activity.class);
                getActivity().startActivity(intent);
            }
        });
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),my_feedback_feedback.class);
                getActivity().startActivity(intent);
            }
        });
        toLogin.setOnClickListener(
                new View.OnClickListener(){
                    public  void onClick(View v){
                        Intent intent=new Intent(MyApplication.getContext(), LoginActivity.class);
                        startActivity(intent);

                    }});

//        toRegister.setOnClickListener(
//                new View.OnClickListener(){
//                    public  void onClick(View v){
//                        Intent intent=new Intent();
//                        intent.setAction("StartLoginView");
//                        startActivity(intent);
//                    }
//
//                }
//        );
        return view;
    }

}
