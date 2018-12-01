package com.androidgroup.view.Xigua;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.bumptech.glide.Glide;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by silence on 2018/10/19.
 */

public class FragmentLive extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.xigua_live,container,false);
        JzvdStd jzvdStd=(JzvdStd)view.findViewById(R.id.video_live);
        jzvdStd.setUp("http://video.pearvideo.com/mp4/adshort/20181025/cont-1462652-13118247_adpkg-ad_hd.mp4","国服第一小改改", Jzvd.SCREEN_WINDOW_LIST);
        Glide.with(MyApplication.getContext()).load("http://p0.ifengimg.com/pmop/2018/0327/BBEE2EEE306CCC280FBDC8B62769B7FECD396D7E_size15_w455_h263.jpeg").into(jzvdStd.thumbImageView);
        return view;
    }
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentLive();
        return fragment;
    }
}
