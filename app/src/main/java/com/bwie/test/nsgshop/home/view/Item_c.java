package com.bwie.test.nsgshop.home.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ViewFlipper;

import com.bwie.test.nsgshop.R;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by admin on 2017/10/24.
 */

public class Item_c extends RecyclerView.ViewHolder{
   public CountdownView countdownView;
    public ViewFlipper vf;
    public Item_c(View itemView) {
        super(itemView);
        vf = (ViewFlipper) itemView.findViewById(R.id.vf);
        countdownView= (CountdownView) itemView.findViewById(R.id.countdownView);
    }
}

