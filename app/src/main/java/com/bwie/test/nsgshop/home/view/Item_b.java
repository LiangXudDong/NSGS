package com.bwie.test.nsgshop.home.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.test.nsgshop.R;

/**
 * Created by admin on 2017/10/24.
 */

public class Item_b extends RecyclerView.ViewHolder{
    public RecyclerView rc;
    public Item_b(View itemView) {
        super(itemView);
        rc= (RecyclerView) itemView.findViewById(R.id.id_recyclerview);
    }
}
