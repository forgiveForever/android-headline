package com.androidgroup.view.Xigua;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidgroup.MyApplication;
import com.androidgroup.R;
import com.androidgroup.entity.VideoInfo;
import com.bumptech.glide.Glide;

import java.util.List;

import cn.jzvd.Jzvd;
import cn.jzvd.JzvdStd;

/**
 * Created by silence on 2018/10/14.
 */

public class XiguaAdapter extends RecyclerView.Adapter<XiguaAdapter.AuthorViewHolder> {

    private OnItemClickListener mOnItemClickListener;
    private List<VideoInfo> mList;
    public XiguaAdapter(List<VideoInfo> videoList){
        mList=videoList;
    }
    @Override
    public XiguaAdapter.AuthorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View childView = inflater.inflate(R.layout.xigua_item, parent, false);
        AuthorViewHolder viewHolder = new AuthorViewHolder(childView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(XiguaAdapter.AuthorViewHolder holder,final int position) {  //对item进行赋值
        VideoInfo videoInfo=mList.get(position);
        if( mOnItemClickListener!= null){ //通过OnItemClickListener接口，来对RecyclerView的item实现点击事件
            holder.itemView.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onClick(position);
                }
            });
            holder. itemView.setOnLongClickListener( new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onLongClick(position);
                    return false;
                }
            });
        }
        holder.jz.setUp(mList.get(position).getVideoSource(), mList.get(position).getTitle(), Jzvd.SCREEN_WINDOW_NORMAL);
        Glide.with(MyApplication.getContext()).load(mList.get(position).getPicSource()).into(holder.jz.thumbImageView);
        holder.author.setText(mList.get(position).getAuthor());
        Glide.with(MyApplication.getContext()).load(mList.get(position).getHeadimg()).into(holder.headimg_xigua);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class AuthorViewHolder extends RecyclerView.ViewHolder {  //获取控件
        JzvdStd jz;
        ImageView headimg_xigua;
        TextView author;
        public AuthorViewHolder(View newsView) {
        super(newsView);
        jz = (JzvdStd) newsView.findViewById(R.id.jz_video_xigua);
        headimg_xigua = (ImageView) newsView.findViewById(R.id.iv_headimg_xigua);
        author = (TextView) newsView.findViewById(R.id.tv_author_xigua);
     }
}
    public interface OnItemClickListener{
        void onClick( int position);
        void onLongClick( int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener ){
        this.mOnItemClickListener=onItemClickListener;
    }
}
