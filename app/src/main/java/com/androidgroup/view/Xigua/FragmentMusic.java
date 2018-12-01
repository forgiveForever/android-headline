package com.androidgroup.view.Xigua;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.androidgroup.R;

/**
 * Created by silence on 2018/10/19.
 */

public class FragmentMusic extends Fragment{
    private MediaPlayer mp=new MediaPlayer();
    private Button play;
    private Boolean flag = true;
    private ImageView img1;
    private ImageView img2;
    private ImageView img3;
    private ImageView img4;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.video_music,container,false);
        img1 = (ImageView) view.findViewById(R.id.img1);
        img2 = (ImageView) view.findViewById(R.id.img2);
        img3 = (ImageView) view.findViewById(R.id.img3);
        img4 = (ImageView) view.findViewById(R.id.img4);


        final MediaPlayer mp =MediaPlayer.create(getActivity(),R.raw.ddd);
        final MediaPlayer mp1 =MediaPlayer.create(getActivity(),R.raw.ddd2);
        final MediaPlayer mp2 =MediaPlayer.create(getActivity(),R.raw.ddd3);
        final MediaPlayer mp3 =MediaPlayer.create(getActivity(),R.raw.ddd4);
        //yes就是MP3文件
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    mp.start();
                }
                else{
                    mp.pause();
                   // mp.stop();
                   // mp.release();
                }
                flag=!flag;
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    mp1.start();
                }
                else{
                    mp1.pause();
                   /* mp1.stop();
                    mp1.release();*/
                }
                flag=!flag;
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    mp3.start();
                }
                else{
                    mp3.pause();
                   /* mp3.stop();
                    mp3.release();*/
                }
                flag=!flag;
            }
        });
        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){
                    mp2.start();
                }
                else{
                    mp2.pause();
                   /* mp3.stop();
                    mp3.release();*/
                }
                flag=!flag;
            }
        });
        return view;
    }
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentMusic();
        return fragment;
    }

}
