package com.androidgroup.bottomFragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidgroup.R;
import com.androidgroup.entity.VideoInfo;
import com.androidgroup.view.Xigua.FragmentLive;
import com.androidgroup.view.Xigua.FragmentMusic;
import com.androidgroup.view.Xigua.FragmentXiguaRecommend;
import com.androidgroup.view.Xigua.FragmentVariety;
import com.androidgroup.view.Xigua.XiguaAdapter;
import com.androidgroup.view.home.FragmentGuanzhu;
import com.androidgroup.view.video.videoDetailsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2018/10/10.
 */

public class FragmentXigua extends Fragment{
//    private Fragment fragmentGuanzhu;
//    private Fragment fragmentRecommend;
//    private Fragment fragmentLive;
//    private Fragment fragmentMusic;
//    private Fragment fragmentVariety;
//    private TextView tv_guanzhu;
//    private TextView tv_live;
//    private TextView tv_recommend;
//    private TextView tv_music;
//    private TextView tv_variety;
//    private List<TextView> titles;
//    private FragmentManager fm;
    private TabLayout tabLayout=null;
    private ViewPager viewPager;
    private String[] mTitles=new String[5];
    private Fragment[] mFragments=new Fragment[5];
    private List<VideoInfo> videoList=new ArrayList<>();
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.xigua,container,false);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager_xigua);
        tabLayout=(TabLayout)view.findViewById(R.id.tabLayout_xigua);
        init();
        XiguaAdapter xiguaAdapter = new XiguaAdapter(videoList);
        xiguaAdapter.setOnItemClickListener(new XiguaAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(), videoDetailsActivity.class);
                getActivity().startActivity(intent);
                /*Intent intent=new Intent(getActivity(),ActivityArticle.class);//传值给ActivityArticle
                Bundle bd=new Bundle();//通过bundle传值给ActivityArticle
//                bd.putInt("id",newsList.get(position).getId());
                bd.putString("title",videoList.get(position).getTitle());
                bd.putString("author",videoList.get(position).getAuthor());
                bd.putString("article",videoList.get(position).getArticle());
                intent.putExtras(bd);
                getActivity().startActivity(intent);*/
                // newsList.get(position);//传id到ActivityArticle进行查询
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        return view;
    }
    private void init(){
        mTitles[0]="关注";
        mTitles[1]="推荐";
        mTitles[2]="直播";
        mTitles[3]="音乐";
        mTitles[4]="综艺";
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        mFragments[0]= FragmentGuanzhu.newsInstance();
        mFragments[1]= FragmentXiguaRecommend.newsInstance();
        mFragments[2]= FragmentLive.newsInstance();
        mFragments[3]= FragmentMusic.newsInstance();
        mFragments[4]= FragmentVariety.newsInstance();
        MyPagerAdapter myPagerAdapter=new MyPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(myPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(1);
        tabLayout.getTabAt(1).select();
        VideoInfo videoInfo=new VideoInfo("1","1","1","1","1");
        videoList.add(videoInfo);
        videoList.add(videoInfo);
        videoList.add(videoInfo);
        videoList.add(videoInfo);
        videoList.add(videoInfo);
        videoList.add(videoInfo);
    }
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
//    public void onClick(View v){
//        switch (v.getId()){
//            case R.id.tv_guanzhu_xigua:selectedTab(0);break;
//            case R.id.tv_recommend_xigua:selectedTab(1);break;
//            case R.id.tv_live_xigua:selectedTab(2);break;
//            case R.id.tv_music_xigua:selectedTab(3);break;
//            case R.id.tv_variety_xigua:selectedTab(4);break;
//        }
//    }
//    public void hideFragment(FragmentTransaction transaction){
//        if (fragmentGuanzhu != null) {
//            transaction.hide(fragmentGuanzhu);
//        }
//        if (fragmentRecommend != null) {
//            transaction.hide(fragmentRecommend);
//        }
//        if (fragmentLive != null) {
//            transaction.hide(fragmentLive);
//        }
//        if (fragmentMusic != null) {
//            transaction.hide(fragmentMusic);
//        }
//        if (fragmentVariety != null) {
//            transaction.hide(fragmentVariety);
//        }
//    }
//    public void clearSelection(){
//        tv_recommend.setTextColor(Color.parseColor("#000000"));
//        tv_guanzhu.setTextColor(Color.parseColor("#000000"));
//        tv_live.setTextColor(Color.parseColor("#000000"));
//        tv_music.setTextColor(Color.parseColor("#000000"));
//        tv_variety.setTextColor(Color.parseColor("#000000"));
//    }
//    public void selectedTab(int index){
//        clearSelection();
//        FragmentTransaction ft=fm.beginTransaction();
//        hideFragment(ft);
//        switch (index){
//            case 0:tv_guanzhu.setTextColor(Color.parseColor("#d43d3d"));
//                if (fragmentGuanzhu == null) {
//                    fragmentGuanzhu = new HomeFragment();
//                    ft.add(R.id.fl_content_xigua, fragmentGuanzhu);//加入到fragmentLayout中
//                } else {
//                    ft.show(fragmentGuanzhu);
//                }break;
//            case 1:tv_recommend.setTextColor(Color.parseColor("#d43d3d"));
//                if (fragmentRecommend == null) {
//                    fragmentRecommend = new HomeFragment();
//                    ft.add(R.id.fl_content_xigua, fragmentRecommend);//加入到fragmentLayout中
//                } else {
//                    ft.show(fragmentRecommend);
//                }break;
//            case 2:tv_live.setTextColor(Color.parseColor("#d43d3d"));
//                if (fragmentLive == null) {
//                    fragmentLive = new HomeFragment();
//                    ft.add(R.id.fl_content_xigua, fragmentLive);//加入到fragmentLayout中
//                } else {
//                    ft.show(fragmentLive);
//                }break;
//            case 3:tv_music.setTextColor(Color.parseColor("#d43d3d"));
//                if (fragmentMusic == null) {
//                    fragmentMusic = new HomeFragment();
//                    ft.add(R.id.fl_content_xigua, fragmentMusic);//加入到fragmentLayout中
//                } else {
//                    ft.show(fragmentMusic);
//                }break;
//            case 4:tv_variety.setTextColor(Color.parseColor("#d43d3d"));
//                if (fragmentVariety == null) {
//                    fragmentVariety = new HomeFragment();
//                    ft.add(R.id.fl_content_xigua, fragmentVariety);//加入到fragmentLayout中
//                } else {
//                    ft.show(fragmentVariety);
//                }break;
//        }
//    }
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentXigua();
        return fragment;
    }

}
