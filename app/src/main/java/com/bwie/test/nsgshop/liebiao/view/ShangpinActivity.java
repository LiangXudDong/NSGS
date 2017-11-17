package com.bwie.test.nsgshop.liebiao.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.base.MyBaseActivity;
import com.bwie.test.nsgshop.liebiao.Presenter.Presenter;
import com.bwie.test.nsgshop.liebiao.bean.AnyEventye;
import com.bwie.test.nsgshop.liebiao.bean.Shangpinl;
import com.bwie.test.nsgshop.liebiao.model.ShangpAdapter;
import com.bwie.test.nsgshop.xiangqing.view.XiangqingActivity;

import org.greenrobot.eventbus.EventBus;

public class ShangpinActivity extends MyBaseActivity implements Iview{
    RecyclerView mRecyclerView;
    Presenter pu=new Presenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangpin);
        mRecyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pu.setlist("1");
    }
    public void setAdapter(final Shangpinl shangpinl){
        Log.d("MAin", "ssss");
        Log.d("MAin", "setAdapter: "+shangpinl);
        ShangpAdapter shangpAdapter = new ShangpAdapter(shangpinl, ShangpinActivity.this);
        mRecyclerView.setAdapter(shangpAdapter);
        shangpAdapter.setOnItemClickLitener(new ShangpAdapter.OnItemClickLitener() {
            @Override
            public void onItemClick(View view, int position) {
                EventBus.getDefault().postSticky(new AnyEventye(shangpinl.getData().get(position).getPid()));
                startActivity(new Intent(ShangpinActivity.this,XiangqingActivity.class));
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }
}
