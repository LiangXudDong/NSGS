package com.bwie.test.nsgshop.home.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bwie.test.nsgshop.R;
import com.youth.banner.Banner;

/**
 * Created by admin on 2017/10/24.
 */

public class Item_aBanner extends RecyclerView.ViewHolder{
    public Banner mybanner;
    public Item_aBanner(View itemView) {
        super(itemView);
        mybanner= (Banner) itemView.findViewById(R.id.mybanner);
    }
}
