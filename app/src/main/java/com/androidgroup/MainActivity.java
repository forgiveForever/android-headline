package com.androidgroup;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidgroup.bottomFragment.FragmentXigua;
import com.androidgroup.bottomFragment.HomeFragment;
import com.androidgroup.bottomFragment.NearbyFragment;
import com.androidgroup.bottomFragment.ReleaseFragment;
import com.androidgroup.entity.NewInfo;
import com.androidgroup.view.system.LoginActivity;
import com.androidgroup.bottomFragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by silence on 2018/10/12.
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private HomeFragment homeFragment;
    private FragmentXigua xiguaFragment;
    private NearbyFragment nearbyFragment;
    private ReleaseFragment releaseFragment;
    private MineFragment mineFragment;
    private MineFragment mineFragment2;//登录之后的fragment
    private List<View> bottomTabs;
    private View homeLayout;
    private View xiguaLayout;
    private View releaseLayout;
    private View nearbyLayout;
    private View mineLayout;
    private ImageView iv_home;
    private TextView tv_home;
    private ImageView iv_xigua;
    private TextView tv_xigua;
    private ImageView iv_release;
    private TextView tv_release;
    private ImageView iv_nearby;
    private TextView tv_nearby;
    private ImageView iv_mine;
    private TextView tv_mine;
    private FragmentManager fragmentManager;
    //private FragmentTransaction transaction;
    private List<NewInfo> mList;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_bottombar);
        init(); //初始化底部导航栏
        fragmentManager=getSupportFragmentManager();
        setSelectTab(0);
    }

    //获取底部导航栏的控件
    public void init(){
        homeLayout=findViewById(R.id.rl_home);
        xiguaLayout=findViewById(R.id.rl_xigua);
        releaseLayout=findViewById(R.id.rl_release);
        nearbyLayout=findViewById(R.id.rl_nearby);
        mineLayout=findViewById(R.id.rl_mine);
        iv_home=(ImageView)findViewById(R.id.iv_home);
        iv_xigua=(ImageView)findViewById(R.id.iv_xigua);
        iv_release=(ImageView)findViewById(R.id.iv_release);
        iv_nearby=(ImageView)findViewById(R.id.iv_nearby);
        iv_mine=(ImageView)findViewById(R.id.iv_mine);
        tv_xigua=(TextView)findViewById(R.id.tv_xigua);
        tv_home=(TextView) findViewById(R.id.tv_home);
        tv_release=(TextView)findViewById(R.id.tv_release);
        tv_nearby=(TextView) findViewById(R.id.tv_nearby);
        tv_mine=(TextView) findViewById(R.id.tv_mine);
        homeLayout.setOnClickListener(this);
        xiguaLayout.setOnClickListener(this);
        releaseLayout.setOnClickListener(this);
        nearbyLayout.setOnClickListener(this);
        mineLayout.setOnClickListener(this);
        bottomTabs=new ArrayList<>(5);
        bottomTabs.add(homeLayout);
        bottomTabs.add(xiguaLayout);
        bottomTabs.add(releaseLayout);
        bottomTabs.add(nearbyLayout);
        bottomTabs.add(mineLayout);
    }

    //底部导航栏点击事件
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.rl_home:
                setSelectTab(0);
                break;
            case R.id.rl_xigua:
                setSelectTab(1);
                break;
            case R.id.rl_release:
                setSelectTab(2);
                break;
            case R.id.rl_nearby:
                setSelectTab(3);
                break;
            case R.id.rl_mine:
                setSelectTab(4);
                break;
            default:
                break;
        }
    }

    //点击切换fragment
    private void setSelectTab(int index) {//底部导航栏点击事件，当第一次点击我的中心时，跳向登录页面
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0://首页
                iv_home.setImageResource(R.drawable.home_s);
                tv_home.setTextColor(Color.parseColor("#f41224"));
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.fl_content, homeFragment);//加入到home.xml的fragmentLayout中
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case 1://西瓜视频
                iv_xigua.setImageResource(R.drawable.xigua_s);
                tv_xigua.setTextColor(Color.parseColor("#f41224"));
                if (xiguaFragment == null) {
                    xiguaFragment = new FragmentXigua();
                    transaction.add(R.id.fl_content, xiguaFragment);
                } else {
                    transaction.show(xiguaFragment);
                }
                break;
            case 2://发布页面
                iv_release.setImageResource(R.drawable.release_s);
                tv_release.setTextColor(Color.parseColor("#f41224"));
                if (releaseFragment == null) {
                    releaseFragment = new ReleaseFragment();
                    transaction.add(R.id.fl_content, releaseFragment);
                } else {
                    transaction.show(releaseFragment);
                }
                break;
            case 3://附近页面
                iv_nearby.setImageResource(R.drawable.nearby_s);
                tv_nearby.setTextColor(Color.parseColor("#f41224"));
                if (nearbyFragment == null) {
                    nearbyFragment = new NearbyFragment();
                    transaction.add(R.id.fl_content, nearbyFragment);
                } else {
                    transaction.show(nearbyFragment);
                }
                break;
            case 4://我的中心页面
                iv_mine.setImageResource(R.drawable.mine_s);
                tv_mine.setTextColor(Color.parseColor("#f41224"));
                if (mineFragment == null) {
                    mineFragment= new MineFragment();
                    transaction.add(R.id.fl_content, mineFragment);
                    Intent goLogin=new Intent(MainActivity.this, LoginActivity.class);
                    startActivityForResult(goLogin,1);
                }
                else {
                    transaction.show(mineFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }
    private void clearSelection() {
        iv_home.setImageResource(R.drawable.home);
        tv_home.setTextColor(Color.parseColor("#82858b"));
        iv_xigua.setImageResource(R.drawable.xigua);
        tv_xigua.setTextColor(Color.parseColor("#82858b"));
        iv_release.setImageResource(R.drawable.ash);
        tv_release.setTextColor(Color.parseColor("#82858b"));
        iv_nearby.setImageResource(R.drawable.nearby);
        tv_nearby.setTextColor(Color.parseColor("#82858b"));
        iv_mine.setImageResource(R.drawable.mine);
        tv_mine.setTextColor(Color.parseColor("#82858b"));
    }
    private void hideFragments(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (xiguaFragment != null) {
            transaction.hide(xiguaFragment);
        }
        if (releaseFragment != null) {
            transaction.hide(releaseFragment);
        }
        if (nearbyFragment != null) {
            transaction.hide(nearbyFragment);
        }
        if (mineFragment != null) {
            transaction.hide(mineFragment);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);//获取来自LoginActivity的intent
        if(requestCode==1&&resultCode==2){
            Toast.makeText(MyApplication.getContext(),"登录成功！",Toast.LENGTH_SHORT).show();
            Bundle bd=new Bundle();
            bd.putString("username2",data.getExtras().getString("username"));
            mineFragment2=new MineFragment();//传名字进来
            mineFragment2.setArguments(bd);
        }

    }
}


