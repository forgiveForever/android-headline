package com.androidgroup.bottomFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.androidgroup.view.my_center.my_center_activity;
import com.androidgroup.view.my_center.my_feedback_feedback;
import com.androidgroup.view.system.LoginActivity;
import com.androidgroup.view.zone.MyCollectionHomeActivity;
import com.androidgroup.view.zone.MyFllowingActivity;
import com.androidgroup.view.zone.MyJingDong;
import com.androidgroup.view.zone.MyMessage;
import com.androidgroup.view.zone.MyReaderActivity;
import com.androidgroup.view.zone.MySetting;

import static com.androidgroup.R.*;

/**
 * Created by silence on 2018/10/25.
 */

public class MineFragment extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(layout.mine,container,false);
        ImageView colletion=(ImageView)view.findViewById(id.iv_collection) ;
        ImageView history=(ImageView)view.findViewById(id.iv_history);
        ImageView reader=(ImageView)view.findViewById(id.my_reader);
        ImageView wallet=(ImageView)view.findViewById(id.my_wallet);
        ImageView feedback=(ImageView)view.findViewById(id.iv_feedback);
        ImageView follow=(ImageView)view.findViewById(id.iv_myfollowing);
        ImageView message=(ImageView)view.findViewById(id.iv_message_my);
        ImageView setting=(ImageView)view.findViewById(id.iv_setting_my);
        ImageView jingdong=(ImageView)view.findViewById(id.iv_jingdong_my);
        TextView username=(TextView)view.findViewById(id.tv_name_mine) ;
        Bundle mBundle=getArguments();
        if(mBundle!=null){
            username.setText(mBundle.getString("username2"));
        }
        follow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MyApplication.getContext(), MyFllowingActivity.class);
                startActivity(intent);
            }
        });
        colletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent5=new Intent(getActivity(),MyCollectionHomeActivity.class);
                getActivity().startActivity(intent5);
            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(getActivity(),MyCollectionHomeActivity.class);
                getActivity().startActivity(intent3);
            }
        });
        reader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getActivity(),MyReaderActivity.class);
                getActivity().startActivity(intent4);
            }
        });
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
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(MyApplication.getContext(), MySetting.class);
                startActivity(intent1);
            }
        });
        jingdong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MyApplication.getContext(), MyJingDong.class);
                startActivity(intent2);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(MyApplication.getContext(), MyMessage.class);
                startActivity(intent2);
            }
        });
        return view;
    }

    public static Fragment newInstance(){
        Fragment fragment=new MineFragment();
        return fragment;
    }

}
