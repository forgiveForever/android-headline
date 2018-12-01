package com.androidgroup.view.zone;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidgroup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyCommodityFragment extends Fragment {


    public MyCommodityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_commodity, container, false);
    }

}
