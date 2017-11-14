package com.bwie.test.nsgshop.home.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.test.nsgshop.R;

/**
 * Created by admin on 2017/10/24.
 */

public class Item_e extends RecyclerView.ViewHolder{
    public RecyclerView rc3;
    public Item_e(View itemView) {
        super(itemView);
        rc3= (RecyclerView) itemView.findViewById(R.id.id_recyclerview2);
    }
}
