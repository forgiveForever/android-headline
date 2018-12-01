package com.androidgroup.view.weather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.androidgroup.R;

import java.util.List;

/**
 * Created by 14457 on 2018/10/18.
 */

public class weather_adapter extends ArrayAdapter {
    private final int resourceId;
    public weather_adapter(Context context, int textViewResourceId, List<weather_item> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        weather_item item = (weather_item) getItem(position); // 获取当前项的item实例
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
        TextView date = (TextView) view.findViewById(R.id.date);
        TextView high = (TextView) view.findViewById(R.id.high);
        TextView fengli = (TextView) view.findViewById(R.id.fengli);
        TextView low = (TextView) view.findViewById(R.id.low);
        TextView fengxiang = (TextView) view.findViewById(R.id.fengxiang);
        TextView type = (TextView) view.findViewById(R.id.type);
        date.setText(item.getDate());//为文本视图设置文本内容
        high.setText(item.getHigh());//为文本视图设置文本内容
        fengli.setText(item.getFengli());//为文本视图设置文本内容
        low.setText(item.getLow());//为文本视图设置文本内容
        fengxiang.setText(item.getFengxiang());//为文本视图设置文本内容
        type.setText(item.getType());//为文本视图设置文本内容
        return view;
    }
}
