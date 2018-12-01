package com.androidgroup.database;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.androidgroup.R;
/**
 * Created by silence on 2018/10/19.
 */

public class FragmentLive extends Fragment{
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.xigua_live,container,false);
        return view;
    }
}
