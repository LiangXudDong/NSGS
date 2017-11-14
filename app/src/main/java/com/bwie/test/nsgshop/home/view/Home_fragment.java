package com.bwie.test.nsgshop.home.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bwie.test.nsgshop.MyApp;
import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.base.MyBaseFragment;
import com.bwie.test.nsgshop.home.bean.HomeBean;
import com.bwie.test.nsgshop.home.model.HomeAdapter;
import com.bwie.test.nsgshop.home.present.PresentUser;
import com.bwie.test.nsgshop.sousuo.Sousuo;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.xys.libzxing.zxing.activity.CaptureActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/11/8.
 */

public class Home_fragment extends MyBaseFragment implements Iview {
    @BindView(R.id.saoma)
    ImageView saoma;
    @BindView(R.id.sousuo)
    EditText sousuo;
    @BindView(R.id.news)
    ImageView news;
    @BindView(R.id.titles)
    RelativeLayout titles;
    @BindView(R.id.xre_xrv)
    XRecyclerView xreXrv;
    Unbinder unbinder;
    HomeAdapter ha;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment_layout, null);
        final PresentUser pu = new PresentUser(this);
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xreXrv.setLayoutManager(layoutManager);
        xreXrv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            //下拉刷新
            public void onRefresh() {
                //当下拉刷新的时候，重新获取数据，所有curr要变回0，并且把集合list清空
                pu.pgetlist();
                xreXrv.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }

        });
        //第一次获取数据
        pu.pgetlist();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.saoma, R.id.sousuo, R.id.news})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.saoma:
                Intent intent = new Intent(MyApp.getContext(), CaptureActivity.class);
                startActivity(intent);
                break;
            case R.id.sousuo:
                Intent in=new Intent(MyApp.getContext(), Sousuo.class);
                getActivity().startActivity(in);
                break;
            case R.id.news:
                break;
        }
    }

    public void GetDate(HomeBean.DataBean data) {
        ha = new HomeAdapter(data, MyApp.getContext());
        xreXrv.setAdapter(ha);

    }
}
