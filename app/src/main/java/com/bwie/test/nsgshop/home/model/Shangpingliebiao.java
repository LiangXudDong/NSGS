package com.bwie.test.nsgshop.home.model;

/**
 * Created by admin on 2017/10/24.
 */

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bwie.test.nsgshop.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

public class Shangpingliebiao extends RecyclerView.Adapter<Shangpingliebiao.MyViewHolder> {
    ArrayList<User> mDatas;
    Context context;

    public Shangpingliebiao(ArrayList<User> mDatas, Context context) {
        this.mDatas = mDatas;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                context).inflate(R.layout.wupinlie_layout, parent,
                false));
        return holder;
    }
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }

    private HomeAdapter.OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(HomeAdapter.OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;

    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position).getTitle());
        String url = mDatas.get(position).getImg();
        if (url.equals("")||url==null){
            holder.img.setImageResource(R.mipmap.ic_launcher);
        }else {
            Uri uri =  Uri.parse(url);
            DraweeController controller = Fresco.newDraweeControllerBuilder()
                    .setUri(uri)
                    .setAutoPlayAnimations(true)
                    .build();
            holder.img.setController(controller);
        }
        if(mOnItemClickLitener!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                @Override
                public boolean onLongClick(View v)
                {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemLongClick(holder.itemView, pos);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        SimpleDraweeView img;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            img= (SimpleDraweeView) itemView.findViewById(R.id.img);
        }
    }
}
