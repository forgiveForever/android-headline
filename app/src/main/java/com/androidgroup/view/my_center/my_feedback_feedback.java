package com.androidgroup.view.my_center;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.androidgroup.R;

/**
 * Created by 14457 on 2018/10/16.
 */

public class my_feedback_feedback  extends AppCompatActivity {
    private ImageView image;
    private Boolean flog = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_feedback_feedback);
        image = (ImageView) findViewById(R.id.my_feedback_feedback);
        image.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    public void onClickddd(View v) {
        //获取组件的资源id
        int id = v.getId();
        switch (id) {
            case R.id.my_feedback_feedback:
                if(flog){
                    image.setImageDrawable(getResources().getDrawable(R.drawable.my_feedback_feedback1));
                }else{
                    image.setImageDrawable(getResources().getDrawable(R.drawable.my_feedback_feedback));
                }
                flog=!flog;
                break;
            default:
                break;
        }
    }
}