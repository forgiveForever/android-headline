package com.androidgroup.bottomFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.androidgroup.view.Xigua.FragmentXiguaRecommend;
import com.androidgroup.view.home.ActivitySearch;
import com.androidgroup.view.home.FragmentCity;
import com.androidgroup.view.home.FragmentGuanzhu;
import com.androidgroup.view.home.FragmentHome;
import com.androidgroup.view.home.FragmentLittleHeadline;

/**
 * Created by silence on 2018/10/12.
 */

public class HomeFragment extends Fragment {

    private TabLayout tabLayout=null;
    private ViewPager viewPager;
    private String[] mTitles=new String[5];
    private Fragment[] mFragments=new Fragment[5];
//    private List<Fragment> mFragments;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.home2,container,false);
        tabLayout=(TabLayout)view.findViewById(R.id.tabLayout);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        View ll_search = (View)view.findViewById(R.id.ll_search);
        ll_search.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MyApplication.getContext(), ActivitySearch.class);
                        startActivity(intent);
                    }
                }
        );
        initHomeView();
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    //顶部导航栏初始化
    private void initHomeView(){
        mTitles[0]="关注";
        mTitles[1]="推荐";
        mTitles[2]="重庆";
        mTitles[3]="视频";
        mTitles[4]="微头条";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        mFragments[0]= FragmentGuanzhu.newsInstance();
        mFragments[1]= FragmentHome.newsInstance();
        mFragments[2]= FragmentCity.newsInstance();
        mFragments[3]= FragmentXiguaRecommend.newsInstance();
        mFragments[4]= FragmentLittleHeadline.newsInstance();
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(4);//setOffscreenPageLimit方法 当前fragment的左右fragment超过当前参数会被销毁
        viewPager.setCurrentItem(1);
        tabLayout.getTabAt(1).select();

    }

    //将tablayout与viewPager绑定
    class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm){
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return mFragments[position];
        }
        @Override
        public int getCount() {
            return mFragments.length;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles[position];
        }
    }


}
