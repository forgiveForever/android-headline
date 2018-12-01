package com.androidgroup.util;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.androidgroup.R;
import com.androidgroup.entity.NearbyEntity;

import org.w3c.dom.Text;

import java.util.List;

import cn.jzvd.JzvdStd;

/**
 * Created by 13969 on 2018/10/15.
 */

public class ListViewAdapter extends BaseAdapter {
    private List<NearbyEntity> nearbyEntityList;
    private Context context;
    private LayoutInflater inflater;


    public ListViewAdapter(List<NearbyEntity> nearbyEntityList,Context context){
       this.nearbyEntityList=nearbyEntityList;
        this.context=context;
        inflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return nearbyEntityList.size();
    }

    @Override
    public Object getItem(int position) {
        return nearbyEntityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
        //布局不变，数据变
        //如果缓存为空，我们生成新的布局作为1个item
        if(convertView==null){
            Log.i("info:", "没有缓存，重新生成"+position);
            //因为getView()返回的对象，adapter会自动赋给ListView
            view = inflater.inflate(R.layout.nearby_item, null);
        }else{
            Log.i("info:", "有缓存，不需要重新生成"+position);
            view = convertView;
        }
        NearbyEntity nearbyEntity = nearbyEntityList.get(position);
        JzvdStd myJzvdStd= (JzvdStd)view.findViewById(R.id.nearby_videoplayer);
        myJzvdStd.setUp("http://jzvd.nathen.cn/342a5f7ef6124a4a8faf00e738b8bee4/cf6d9db0bd4d41f59d09ea0a81e918fd-5287d2089db37e62345123a1be272f8b.mp4"
                , "饺子快长大", JzvdStd.SCREEN_WINDOW_NORMAL);
      //  Glide.with(this).load("http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png").into(myJzvdStd.thumbImageView);
        ImageView user_img=(ImageView) view.findViewById(R.id.nearby_user_img);

        TextView user_name=(TextView) view.findViewById(R.id.nearby_user_name);
        user_name.setText(nearbyEntity.getName());
        TextView distance=(TextView) view.findViewById(R.id.nearby_distance);
        distance.setText(nearbyEntity.getDistance());
        TextView comment_num=(TextView) view.findViewById(R.id.nearby_comment_num);
        comment_num.setText(nearbyEntity.getComment());
        TextView fabulous_num    =(TextView)view.findViewById(R.id.nearby_fabulous_num);
        fabulous_num.setText(nearbyEntity.getFabulous());
        TextView  reprint_num =(TextView)view.findViewById(R.id.nearby_reprint_num);
        reprint_num.setText(nearbyEntity.getReprint());
        return view;
    }
}
