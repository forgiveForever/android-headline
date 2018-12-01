package com.androidgroup.view.home;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.androidgroup.HomeHeadlineFragment.HomeHeadlineAll;
import com.androidgroup.HomeHeadlineFragment.HomeHeadlineAnswer;
import com.androidgroup.HomeHeadlineFragment.HomeHeadlineContent;
import com.androidgroup.HomeHeadlineFragment.HomeHeadlineSmallvideo;
import com.androidgroup.HomeHeadlineFragment.HomeHeadlineVideo;
import com.androidgroup.R;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by 刘丹丹 on 2018/10/16.
 */

public class HomeHeadLineIntroduce extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mContentVp;
    private List<String> tabTitles;
    private List<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;
    private TabLayout mTabTl;
    private String[] topTitle = {"全部","文章","视频","问答","小视频"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_headline_introduce);
        initView();
        initContent();
        initTab();
    }

    public void initView(){
        findViewById(R.id.iv_return).setOnClickListener(this);
        mContentVp = (ViewPager) findViewById(R.id.vp_content1);
        mTabTl = (TabLayout) findViewById(R.id.tl_tab1);
    }

    @Override
    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.iv_return:
                //intent=new Intent(this,FragmentLittleHeadline.class);
                finish();
                break;

        }

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
            if(tabTitles.get(i).equals("全部"))
                tabFragments.add(new HomeHeadlineAll());
            else if(tabTitles.get(i).equals("文章"))
                tabFragments.add(new HomeHeadlineContent());
            else if(tabTitles.get(i).equals("视频"))
                tabFragments.add(new HomeHeadlineVideo());
            else if(tabTitles.get(i).equals("问答"))
                tabFragments.add(new HomeHeadlineAnswer());
            else if(tabTitles.get(i).equals("小视频"))
                tabFragments.add(new HomeHeadlineSmallvideo());
        }
        contentAdapter =new ContentPagerAdapter(getSupportFragmentManager());
        mContentVp.setAdapter(contentAdapter);
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
        mTabTl.setupWithViewPager(mContentVp);
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
