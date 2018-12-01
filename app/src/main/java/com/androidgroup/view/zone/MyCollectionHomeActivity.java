package com.androidgroup.view.zone;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.androidgroup.R;
import com.androidgroup.bottomFragment.MineFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MyCollectionHomeActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager mCollectionVP;
    private List<String> tabTitles;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;
    private TabLayout mTabTl;
    private String[] topTitle = {"收藏","评论","点赞","历史","推送"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_collection_home);

        initView();
        initContent();
        initTab();
    }
    @Override
    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.exit_my_collection:
                intent=new Intent(this,MineFragment.class);
                break;

        }
        }


    public void initView(){
        findViewById(R.id.exit_my_collection).setOnClickListener(this);
        mCollectionVP = (ViewPager) findViewById(R.id.vp_mycollection);
        mTabTl = (TabLayout) findViewById(R.id.tb_mycollection);
    }

    /**
     * 设置并添加tab导航栏内容
     */
    public void initContent(){
        tabTitles=new ArrayList<>();
        tabFragments=new ArrayList<>();
        for(int i=0;i<topTitle.length;i++){
            tabTitles.add(topTitle[i]);
        }
        for(int i=0;i<tabTitles.size();i++){
            if(tabTitles.get(i).equals("收藏"))
                tabFragments.add(new MyCollectionFragment());
            else if(tabTitles.get(i).equals("评论"))
                tabFragments.add(new MyCommentionFragment());
            else if(tabTitles.get(i).equals("点赞"))
                tabFragments.add(new MyLikeFragment());
            else if(tabTitles.get(i).equals("历史"))
                tabFragments.add(new MyHistoryFragment());
            else if(tabTitles.get(i).equals("推送"))
                tabFragments.add(new MyCommodityFragment());
        }
        contentAdapter =new MyCollectionHomeActivity.ContentPagerAdapter(getSupportFragmentManager());
        mCollectionVP.setAdapter(contentAdapter);
    }


    /**
     * 初始化tab并为每个导航栏内容绑定相应页面
     */
    private void initTab(){
        mTabTl.setTabMode(TabLayout.MODE_SCROLLABLE);
        //第一个为未选中字体颜色，第二个为选中字体颜色
        mTabTl.setTabTextColors(ContextCompat.getColor(this, R.color.black), ContextCompat.getColor(this, R.color.colorRed));
        //下划线颜色
        mTabTl.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.colorRed));
        ViewCompat.setElevation(mTabTl, 5);
        //绑定viewPager
        mTabTl.setupWithViewPager(mCollectionVP);
        mTabTl.post(new Runnable() {
            @Override
            public void run() {
                setIndicator(mTabTl,-3,-3);
            }
        });

    }

    /**
     * 设置tab的宽度和高度
     */
    public void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }


    class ContentPagerAdapter extends FragmentPagerAdapter {

        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabTitles.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles.get(position);
        }

    }
}
