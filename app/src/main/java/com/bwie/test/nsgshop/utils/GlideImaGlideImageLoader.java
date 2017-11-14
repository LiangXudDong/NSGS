package com.bwie.test.nsgshop.utils;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bwie.test.nsgshop.MyWebView;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by admin on 2017/11/9.
 */

public class GlideImaGlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(final Context context, final Object path, ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(path.equals("https://image.yunifang.com/yunifang/images/goods/ad0/17100908319495742677657462.jpg")){
                    Intent in=new Intent(context, MyWebView.class);
                    in.putExtra("url","http://h.yunifang.com/h/comment.html");
                    context.startActivity(in);
                }else if(path.equals("https://image.yunifang.com/yunifang/images/goods/ad0/170823222049920659891841095.jpg")){
                    Intent in=new Intent(context, MyWebView.class);
                    in.putExtra("url","http://h.yunifang.com/h/video.html");
                    context.startActivity(in);
                }else{
                    Toast.makeText(context, "没有连接", Toast.LENGTH_SHORT).show();
                }
            }
        });
        Glide.with(context).load(path).into(imageView);
    }
}
