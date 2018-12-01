package com.androidgroup.view.Xigua;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.androidgroup.database.MyDatabaseHelper;
import com.androidgroup.entity.NewInfo;
import com.androidgroup.entity.VideoInfo;
import com.androidgroup.view.video.videoDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JzvdStd;

/**
 * Created by silence on 2018/10/19.
 */

public class FragmentXiguaRecommend extends Fragment{
    private List<VideoInfo> videoList=new ArrayList<>();
    private MyDatabaseHelper myDatabaseHelper;
    private FragmentXiguaRecommend xiguaRecommend;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view =inflater.inflate(R.layout.xigua_recommend,container,false);
        View v2=inflater.inflate(R.layout.xigua_item,container,false);
        myDatabaseHelper=new MyDatabaseHelper(MyApplication.getContext());
        RecyclerView recyclerView_xigua=(RecyclerView)view.findViewById(R.id.recyclerView_recommend_xigua);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView_xigua.setLayoutManager(linearLayoutManager);
        if(savedInstanceState==null){//第一次初始化

            init();
        }
        readData();
        videoList.size();
        XiguaAdapter xiguaAdapter=new XiguaAdapter(videoList);
        recyclerView_xigua.setAdapter(xiguaAdapter);
        xiguaAdapter.setOnItemClickListener(new XiguaAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent=new Intent(getActivity(), videoDetailsActivity.class);
                Bundle bd=new Bundle();
                bd.putString("title",videoList.get(position).getTitle());
                bd.putString("videoSource",videoList.get(position).getVideoSource());
                bd.putString("headimg",videoList.get(position).getHeadimg());
                bd.putString("author",videoList.get(position).getAuthor());
                intent.putExtras(bd);
                getActivity().startActivity(intent);
            }

            @Override
            public void onLongClick(int position) {

            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    //查询数据库
    public void readData(){
        String sql="select * from videos";
        SQLiteDatabase db=myDatabaseHelper.getReadableDatabase();  //连接数据库，没有则创建
        Cursor cursor=db.rawQuery(sql,new String[]{});
        while(cursor.moveToNext()){
            //int id=cursor.getInt(cursor.getColumnIndex("id"));
            String title=cursor.getString(cursor.getColumnIndex("title"));
            String videoSource=cursor.getString(cursor.getColumnIndex("videoSource"));
            String headimg=cursor.getString(cursor.getColumnIndex("headimg"));
            String pic=cursor.getString(cursor.getColumnIndex("pic"));
            String author=cursor.getString(cursor.getColumnIndex("author"));
            //int type=cursor.getInt(cursor.getColumnIndex("type"));
            VideoInfo videoInfo=new VideoInfo(title,videoSource,pic,headimg,author);//实例化NewInfo类并赋值
            videoList.add(videoInfo);
        }
        cursor.close();
    }

    //向news表中插入数据
    public void insertData(String title,String videoSource,String pic,String headimg,String author){
        SQLiteDatabase db=myDatabaseHelper.getWritableDatabase();//连接数据库，没有则创建
        ContentValues values=new ContentValues();//
        values.put("title",title);
        values.put("videoSource",videoSource);
        values.put("pic",pic);
        values.put("headimg",headimg);
        values.put("author",author);
        //values.put("type",type);
        db.insert("videos",null,values);
        values.clear();
    }
    public void init(){
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","http://jzvd-pic.nathen.cn/jzvd-pic/1bb2ebbe-140d-4e2e-abd2-9e7e564f71ac.png","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2287748162,2131480058&fm=26&gp=0.jpg","花椒大料");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582733021&di=59168a59812735999ea30c262b5c60ce&imgtype=0&src=http%3A%2F%2Fimg2015.zdface.com%2F20180906%2F78fe9fd89b186a55dbd1b7efcffc8273.jpg","https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3737036207,3664817563&fm=26&gp=0.jpg","幺妹讲故事");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582733020&di=f62fbe1b1faefac1477a9db2222873da&imgtype=0&src=http%3A%2F%2Fshp.qpic.cn%2Fqqvideo_ori%2F0%2Fm0771e8gw6s_496_280%2F0","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540575420441&di=c2d520b387f008a10e5bfd2d8ee34383&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F7c49a0c8f194f5cdca6ed9ab7946667a663fa80d2789-mw2B33_fw658","七七小剧场");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582733072&di=7818f27ae497405b2b8f1b89e5dd71e1&imgtype=0&src=http%3A%2F%2Fshp.qpic.cn%2Fqqvideo_ori%2F0%2Fp0757dxdpf4_496_280%2F0","https://img.52z.com/upload/news/image/20171129/20171129121641_51605.jpg","莉莉开心乐");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582940098&di=ede78e0068a8b69a27237dee2cd0bc27&imgtype=0&src=http%3A%2F%2Fimg.9553.com%2Fuploadfile%2F2018%2F0605%2F20180605014017654.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540575420439&di=d69d763837639a165ec504ab71f6024d&imgtype=0&src=http%3A%2F%2Fimg.bqatj.com%2Fimg%2Fe8de4a91c77701c4.jpg","佳美谈天下");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582940099&di=29f877ec57dbad0e9b9971e9157b3a63&imgtype=0&src=http%3A%2F%2Fwww.haoz.net%2Fd%2Ffile%2F2018-10-03%2F5eb4229326f7ed9f551811ce3df8df56.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540575732899&di=7b7969d802cb5e6701baf67d00f71ea2&imgtype=0&src=http%3A%2F%2Fimg.5snow.com%2Ffiles%2F0%2F0f113d14868e422e77b4f6e46d31043c.gif","香蕉剧中剧");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2079998410,926856509&fm=26&gp=0.jpg","https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2287748162,2131480058&fm=26&gp=0.jpg","一口毒奶");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582733020&di=f62fbe1b1faefac1477a9db2222873da&imgtype=0&src=http%3A%2F%2Fshp.qpic.cn%2Fqqvideo_ori%2F0%2Fm0771e8gw6s_496_280%2F0","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540575420441&di=c2d520b387f008a10e5bfd2d8ee34383&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F7c49a0c8f194f5cdca6ed9ab7946667a663fa80d2789-mw2B33_fw658","七七小剧场");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582733072&di=7818f27ae497405b2b8f1b89e5dd71e1&imgtype=0&src=http%3A%2F%2Fshp.qpic.cn%2Fqqvideo_ori%2F0%2Fp0757dxdpf4_496_280%2F0","https://img.52z.com/upload/news/image/20171129/20171129121641_51605.jpg","莉莉开心乐");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582940098&di=ede78e0068a8b69a27237dee2cd0bc27&imgtype=0&src=http%3A%2F%2Fimg.9553.com%2Fuploadfile%2F2018%2F0605%2F20180605014017654.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540575420439&di=d69d763837639a165ec504ab71f6024d&imgtype=0&src=http%3A%2F%2Fimg.bqatj.com%2Fimg%2Fe8de4a91c77701c4.jpg","佳美谈天下");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582733072&di=7818f27ae497405b2b8f1b89e5dd71e1&imgtype=0&src=http%3A%2F%2Fshp.qpic.cn%2Fqqvideo_ori%2F0%2Fp0757dxdpf4_496_280%2F0","https://img.52z.com/upload/news/image/20171129/20171129121641_51605.jpg","莉莉开心乐");
        insertData("饺子","http://jzvd.nathen.cn/c6e3dc12a1154626b3476d9bf3bd7266/6b56c5f0dc31428083757a45764763b0-5287d2089db37e62345123a1be272f8b.mp4","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540582940098&di=ede78e0068a8b69a27237dee2cd0bc27&imgtype=0&src=http%3A%2F%2Fimg.9553.com%2Fuploadfile%2F2018%2F0605%2F20180605014017654.jpg","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1540575420439&di=d69d763837639a165ec504ab71f6024d&imgtype=0&src=http%3A%2F%2Fimg.bqatj.com%2Fimg%2Fe8de4a91c77701c4.jpg","佳美谈天下");

    }
    public static Fragment newsInstance(){
        Fragment fragment=new FragmentXiguaRecommend();
        return fragment;
    }

    @Override
    public void onPause() {
        super.onPause();

    }
    /*    @Override
    public void onClick(View v) {
        //获取组件的资源id
        int id = v.getId();
        switch (id) {
            case R.id.ll_intend:
                //跳转页面
                Intent intent=new Intent(getActivity(),WeatherActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }*/
}
