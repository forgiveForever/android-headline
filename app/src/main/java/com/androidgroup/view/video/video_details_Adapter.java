package com.androidgroup.view.video;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidgroup.R;

import java.util.List;

/**
 * Created by 14457 on 2018/10/16.
 */

public class video_details_Adapter extends ArrayAdapter {
    private final int resourceId;
    public video_details_Adapter(Context context, int textViewResourceId, List<Video_details_item> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Video_details_item item = (Video_details_item) getItem(position); // 获取当前项的item实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        ImageView head_img = (ImageView) view.findViewById(R.id.head_img);//获取该布局内的图片视图
        TextView name = (TextView) view.findViewById(R.id.name);//获取该布局内的文本视图
        head_img.setImageResource(item.getImageId());//为图片视图设置图片资源
        name.setText(item.getName());//为文本视图设置文本内容
        return view;
    }

}
