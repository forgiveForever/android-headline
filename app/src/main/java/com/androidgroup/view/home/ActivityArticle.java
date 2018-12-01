package com.androidgroup.view.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.bumptech.glide.Glide;

/**
 * Created by silence on 2018/10/22.
 */

public class ActivityArticle extends AppCompatActivity {
    private View articleLayout;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_content);
        TextView titile=(TextView)findViewById(R.id.tv_title_detail);
        TextView author=(TextView)findViewById(R.id.tv_author_detail);
        TextView news=(TextView)findViewById(R.id.tv_news_details);
        ImageView back=(ImageView)findViewById(R.id.iv_back_details);
        ImageView pic=(ImageView)findViewById(R.id.iv_pic_details);
        Intent intent=getIntent();
        titile.setText(intent.getExtras().getString("title"));
        author.setText(""+intent.getExtras().getString("author"));
        news.setText(intent.getExtras().getString("article"));
        String picSource=intent.getExtras().getString("pic");
        Glide.with(MyApplication.getContext()).load(picSource).into(pic);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(10);
                finish();
            }
        });
        //articleLayout=findViewById(R.id.fl_news_details);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_news_details,FragmentArticle.newsInstance()).commit();
//        Intent intent=getIntent();
//        String title=intent.getStringExtra("title");
//        String author=intent.getStringExtra("author");
//        String article=intent.getStringExtra("article");
//        TextView news=(TextView)findViewById(R.id.article_home);
//        news.setText(article);
    }
}
