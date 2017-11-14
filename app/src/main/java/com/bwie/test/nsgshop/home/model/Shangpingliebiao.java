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

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
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
