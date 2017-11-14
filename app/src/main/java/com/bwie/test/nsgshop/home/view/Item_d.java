package com.bwie.test.nsgshop.home.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.test.nsgshop.R;

/**
 * Created by admin on 2017/10/24.
 */

public class Item_d extends RecyclerView.ViewHolder{
    public RecyclerView rc2;
    public Item_d(View itemView) {
        super(itemView);
        rc2= (RecyclerView) itemView.findViewById(R.id.id_recyclerview3);
    }
}
