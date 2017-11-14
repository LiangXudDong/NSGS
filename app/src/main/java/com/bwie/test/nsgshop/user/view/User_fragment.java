package com.bwie.test.nsgshop.user.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bwie.test.nsgshop.Login.view.Denglu;
import com.bwie.test.nsgshop.MyApp;
import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.base.BaseFragment;
import com.bwie.test.nsgshop.base.MyBaseFragment;
import com.bwie.test.nsgshop.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by admin on 2017/11/8.
 */

public class User_fragment extends MyBaseFragment implements BaseFragment {
    @BindView(R.id.touxiang)
    ImageView touxiang;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.shangpin)
    Button shangpin;
    @BindView(R.id.dianpu)
    Button dianpu;
    @BindView(R.id.zuji)
    Button zuji;
    @BindView(R.id.didantu)
    ImageView didantu;
    @BindView(R.id.weifukuan)
    Button weifukuan;
    @BindView(R.id.daifukuan)
    Button daifukuan;
    @BindView(R.id.daishouhuo)
    Button daishouhuo;
    @BindView(R.id.daipingjia)
    Button daipingjia;
    @BindView(R.id.tuikuan)
    Button tuikuan;
    @BindView(R.id.dindannav)
    LinearLayout dindannav;
    @BindView(R.id.dindan)
    RelativeLayout dindan;
    @BindView(R.id.caichantu)
    ImageView caichantu;
    @BindView(R.id.yufukuan)
    Button yufukuan;
    @BindView(R.id.chongzhika)
    Button chongzhika;
    @BindView(R.id.daijinquan)
    Button daijinquan;
    @BindView(R.id.hongbao)
    Button hongbao;
    @BindView(R.id.jifen)
    Button jifen;
    @BindView(R.id.caichannav)
    LinearLayout caichannav;
    @BindView(R.id.caichan)
    RelativeLayout caichan;
    @BindView(R.id.shouhuodizhitu)
    ImageView shouhuodizhitu;
    @BindView(R.id.shouhuodizhi)
    RelativeLayout shouhuodizhi;
    @BindView(R.id.xitongshezhitu)
    ImageView xitongshezhitu;
    @BindView(R.id.xitongshezhi)
    RelativeLayout xitongshezhi;
    Unbinder unbinder;
    @BindView(R.id.tc)
    Button tc;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment_layout, null);
        unbinder = ButterKnife.bind(this, view);
        SharedPreferencesUtils.setParam(getActivity(), "String", "没有登录");
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @Override
    public void onStart() {
        super.onStart();
        String param = (String) SharedPreferencesUtils.getParam(getActivity(), "name", "没有登录");
        name.setText(param);
    }



    @OnClick({R.id.touxiang, R.id.tc})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.touxiang:
                Intent in = new Intent(getActivity(), Denglu.class);
                getActivity().startActivityForResult(in, 2);
                break;
            case R.id.tc:
                SharedPreferencesUtils.setParam(MyApp.getContext(),"name","没有登录");
                Intent ins = new Intent(getActivity(), Denglu.class);
                getActivity().startActivityForResult(ins, 2);
                break;
        }
    }
}
