package com.androidgroup.view.nearby;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.androidgroup.R;
import com.androidgroup.entity.NearbyEntity;
import com.androidgroup.util.ListViewAdapter;
import com.androidgroup.util.SQLiteUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 13969 on 2018/10/15.
 */

public class NearbyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nearby);
        ListView listView =(ListView) findViewById(R.id.nearby_listview);

        //测试sqlit数据
        Thread thread =new Thread(new Runnable() {
            @Override
            public void run() {
                SQLiteUtil dao =new SQLiteUtil(NearbyActivity.this);

                dao.display();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<NearbyEntity> list =new ArrayList<>();
        for(int n=0; n<4;n++){
            NearbyEntity nearbyEntity =new NearbyEntity();
            nearbyEntity.setName("小飞飞");
            nearbyEntity.setComment("1");
            nearbyEntity.setContent("小飞飞的生活很痛苦");
            nearbyEntity.setDistance("4km");
            nearbyEntity.setFabulous("6");
            nearbyEntity.setVediopath("sdfsfs");
            nearbyEntity.setReprint("5989");
            list.add(nearbyEntity);
        }
        listView.setAdapter(new ListViewAdapter(list,NearbyActivity.this));
    }
}
