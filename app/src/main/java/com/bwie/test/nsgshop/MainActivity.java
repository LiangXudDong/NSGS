package com.bwie.test.nsgshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.bwie.test.nsgshop.Login.view.Denglu;
import com.bwie.test.nsgshop.base.MyBaseActivity;
import com.bwie.test.nsgshop.cart.view.Cart_fragment;
import com.bwie.test.nsgshop.classfity.view.Classfity_fragemnt;
import com.bwie.test.nsgshop.home.view.Home_fragment;
import com.bwie.test.nsgshop.user.view.User_fragment;
import com.bwie.test.nsgshop.utils.SharedPreferencesUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MyBaseActivity {

    @BindView(R.id.zfragment)
    LinearLayout zfragment;
    @BindView(R.id.home)
    RadioButton home;
    @BindView(R.id.fclass)
    RadioButton fclass;
    @BindView(R.id.cart)
    RadioButton cart;
    @BindView(R.id.user)
    RadioButton user;
    private Cart_fragment cart_fragment;
    private Classfity_fragemnt classfity_fragemnt;
    private Home_fragment home_fragment;
    private User_fragment user_fragment;
    private FragmentManager man;
    private String param = (String) SharedPreferencesUtils.getParam(MyApp.getContext(), "name", "没有登录");
    int u=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //创建Fragment对象，并且添加到
        initfragment();
        //默认第一个页面，首页按钮点击
        home.setChecked(true);

    }

    @Override
    protected void onStart() {
        super.onStart();
        param = (String) SharedPreferencesUtils.getParam(MyApp.getContext(), "name", "没有登录");
        if(param.equals("没有登录")){
            man.beginTransaction().hide(cart_fragment).hide(classfity_fragemnt).hide(user_fragment).show(home_fragment).commit();
            home.setChecked(true);
        }else{
            if(u==3){
                man.beginTransaction().hide(cart_fragment).hide(classfity_fragemnt).hide(home_fragment).show(user_fragment).commit();
                user.setChecked(true);
            }else if(u==2){
                man.beginTransaction().hide(home_fragment).hide(classfity_fragemnt).hide(user_fragment).show(cart_fragment).commit();
                cart.setChecked(true);
            }
        }

    }

    private void initfragment() {
        cart_fragment = new Cart_fragment();
        classfity_fragemnt = new Classfity_fragemnt();
        home_fragment = new Home_fragment();
        user_fragment = new User_fragment();
        man = getSupportFragmentManager();
        FragmentTransaction ft = man.beginTransaction();
        ft.add(R.id.zfragment,cart_fragment);
        ft.add(R.id.zfragment,classfity_fragemnt);
        ft.add(R.id.zfragment,home_fragment);
        ft.add(R.id.zfragment,user_fragment);
        ft.hide(cart_fragment).hide(classfity_fragemnt).hide(user_fragment).show(home_fragment).commit();
    }

    @OnClick({R.id.home, R.id.fclass, R.id.cart, R.id.user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home:
                man.beginTransaction().hide(cart_fragment).hide(classfity_fragemnt).hide(user_fragment).show(home_fragment).commit();
                break;
            case R.id.fclass:
                man.beginTransaction().hide(cart_fragment).hide(home_fragment).hide(user_fragment).show(classfity_fragemnt).commit();
                break;
            case R.id.cart:
                u=2;
                if(param.equals("没有登录")){
                    man.beginTransaction().hide(home_fragment).hide(classfity_fragemnt).hide(user_fragment).show(cart_fragment).commit();
                    Intent login=new Intent(MyApp.getContext(), Denglu.class);
                    startActivity(login);
                }else{
                    man.beginTransaction().hide(home_fragment).hide(classfity_fragemnt).hide(user_fragment).show(cart_fragment).commit();
                }
                break;
            case R.id.user:
                u=3;
                if(param.equals("没有登录")){
                    man.beginTransaction().hide(cart_fragment).hide(classfity_fragemnt).hide(home_fragment).show(user_fragment).commit();
                    Intent login=new Intent(MyApp.getContext(), Denglu.class);
                    startActivity(login);
                }else{
                    man.beginTransaction().hide(cart_fragment).hide(classfity_fragemnt).hide(home_fragment).show(user_fragment).commit();
                }
                break;
        }
    }
    long startTime = 0;

    @Override
    public void onBackPressed() {

        long currentTime = System.currentTimeMillis();
        if ((currentTime - startTime) >= 2000) {
            Toast.makeText(MainActivity.this, "再按一次退出", Toast.LENGTH_SHORT).show();
            startTime = currentTime;
        } else {
            finish();
        }
    }
}
