package com.androidgroup.view.video;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.androidgroup.view.weather.WeatherActivity;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by 14457 on 2018/10/15.
 */

public class videoDetailsActivity extends AppCompatActivity{
    private List<Video_details_item> video_details_itemList = new ArrayList<Video_details_item>();

    private JzvdStd jzvdStd;
    private TextView author;
    private ImageView headimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_details);
        init();
        headimg=(ImageView)findViewById(R.id.iv_headimg_video);
        author=(TextView)findViewById(R.id.tv_author_video) ;
        Intent intent=getIntent();
        String titles=intent.getExtras().getString("title");
        String videos=intent.getExtras().getString("videoSource");
        String headimgs=intent.getExtras().getString("headimg");
        String authors=intent.getExtras().getString("author");
        jzvdStd.setUp(videos,titles, Jzvd.SCREEN_WINDOW_NORMAL);
        Glide.with(MyApplication.getContext()).load(headimgs).into(headimg);
        author.setText(authors);
            initItem(); // 初始化数据
        video_details_Adapter adapter = new video_details_Adapter(videoDetailsActivity.this, R.layout.video_details_item, video_details_itemList);
        ListView listView = (ListView) findViewById(R.id.xigua_detail_list);
        listView.setAdapter(adapter);
}

    private  void initItem(){
        Video_details_item item1 = new Video_details_item("意大利炮",R.drawable.head2);
        video_details_itemList.add(item1);
        Video_details_item item2 = new Video_details_item("德国小钢炮",R.drawable.head3);
        video_details_itemList.add(item2);
        Video_details_item item3 = new Video_details_item("德克萨斯小洋炮",R.drawable.head4);
        video_details_itemList.add(item3);
        Video_details_item item4 = new Video_details_item("黑不溜秋炮",R.drawable.head5);
        video_details_itemList.add(item4);

    }
    //指定onClick属性方式
    //传人的View对象，就是用户按下的那个按钮对象
    public void goToWeather(View v){
        //获取组件的资源id
        int id = v.getId();
        switch (id) {
            case R.id.guanzhu:
                Toast.makeText(getApplicationContext(),"关注成功",Toast.LENGTH_SHORT).show();
                //跳转页面
                Intent intent=new Intent(this,WeatherActivity.class);
                startActivity(intent);
                break;
            case R.id.share_img:
//                Toast.makeText(getApplicationContext(),"他还不是你的好友，暂不支持分享",Toast.LENGTH_SHORT).show();
                setResult(1);
                finish();
                break;
            default:
                break;
        }

    }
    public void init(){
        jzvdStd = (JzvdStd)findViewById(R.id.JzvdStd);
        headimg=(ImageView)findViewById(R.id.iv_headimg_video);
        author=(TextView)findViewById(R.id.tv_author_video);
    }
}