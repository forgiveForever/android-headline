package com.androidgroup.view.my_center;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.androidgroup.R;

/**
 * Created by 14457 on 2018/10/16.
 */

public class my_center_activity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_wallet);
        imageView = (ImageView) findViewById(R.id.my_wallet);
    }

    public void ddd(View v) {
        //获取组件的资源id
        int id = v.getId();
        switch (id) {
            case R.id.my_feedback_feedback:
                //跳转页面
                Intent intent=new Intent(this,my_feedback_feedback.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
