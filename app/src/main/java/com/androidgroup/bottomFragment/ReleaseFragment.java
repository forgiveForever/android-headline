package com.androidgroup.bottomFragment;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.SyncStateContract;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.androidgroup.R;

/**
 * Created by silence on 2018/10/17.
 */

public class ReleaseFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_release, container, false);
        ImageView modify=(ImageView)view.findViewById(R.id.iv_open_release);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent _video_intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
//保存路径
                _video_intent.putExtra(MediaStore.EXTRA_OUTPUT, Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath() + "/Camera/");
//分辨率0最低，1最高
                _video_intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);
//开启系统摄像机
                startActivity(_video_intent);
            }
            });
        return view;
    }
}
