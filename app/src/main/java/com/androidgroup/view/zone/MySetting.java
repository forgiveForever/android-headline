package com.androidgroup.view.zone;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.androidgroup.R;

/**
 * Created by silence on 2018/10/30.
 */

public class MySetting extends AppCompatActivity{
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_setting);
        ImageView back=(ImageView)findViewById(R.id.iv_back_setting);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
