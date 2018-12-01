package com.androidgroup;
/**
 * Created by silence on 2018/10/12.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidgroup.entity.NewInfo;
import com.bumptech.glide.Glide;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.AuthorViewHolder> {
    private List<NewInfo> mList;
    private OnItemClickListener mOnItemClickListener;
    public NewsAdapter(List<NewInfo> newsList){
        mList=newsList;
    }

    @Override
    public AuthorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View childView=inflater.inflate(R.layout.news_item,parent,false);
        AuthorViewHolder viewHolder=new AuthorViewHolder(childView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(AuthorViewHolder holder, final int position) {  //数据处理，对获取到的控件进行赋值
        NewInfo newInfo=mList.get(position);
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

        //对控件进行赋值
        holder.newsTitle.setText(newInfo.getTitle());
        holder.newsAuthor.setText(newInfo.getAuthor());
        holder.newsComment.setText(newInfo.getComment());
        Glide.with(MyApplication.getContext()).load(newInfo.getPicSource()).into(holder.newsPic);
        //holder.type=newInfo.getType();
      //  holder.id=newInfo.getId();
        //holder.article.setText(newInfo.getArticle());
    }

    @Override
    public int getItemCount() {  //获取item数量
        return mList.size();
    }
    static class AuthorViewHolder extends RecyclerView.ViewHolder{  //获取相对应的控件
        TextView newsTitle;
        TextView newsAuthor;
        TextView newsComment;
        ImageView newsPic;
        int type;
        int id;
        TextView article;
        public AuthorViewHolder(View newsView){
            super(newsView);
            newsTitle=(TextView)newsView.findViewById(R.id.news_title);
            newsAuthor=(TextView)newsView.findViewById(R.id.news_author);
            newsComment=(TextView)newsView.findViewById(R.id.news_comment);
            newsPic=(ImageView)newsView.findViewById(R.id.news_pic);
            //article=(TextView)newsView.findViewById(R.id.news);
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
