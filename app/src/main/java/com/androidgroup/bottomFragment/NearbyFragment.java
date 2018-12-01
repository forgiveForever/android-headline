package com.androidgroup.bottomFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.androidgroup.R;
import com.androidgroup.entity.NearbyEntity;
import com.androidgroup.util.ListViewAdapter;
import com.androidgroup.util.SQLiteUtil;
import com.androidgroup.view.nearby.NearbyActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2018/10/17.
 */

public class NearbyFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.nearby,container,false);
        ListView listView =(ListView) view.findViewById(R.id.nearby_listview);

                    //测试sqlit数据
                   /* Thread thread =new Thread(new Runnable() {
                        @Override
                        public void run() {
                            SQLiteUtil dao =new SQLiteUtil(NearbyFragment.this.getActivity());

                            dao.display();
                        }
                    });
                    thread.start();
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*/

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
        listView.setAdapter(new ListViewAdapter(list,NearbyFragment.this.getActivity()));

        return view;
    }
}
