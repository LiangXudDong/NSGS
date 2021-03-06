package com.bwie.test.nsgshop.Login.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.test.nsgshop.Login.present.PresentUser;
import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.base.MyBaseActivity;
import com.bwie.test.nsgshop.register.view.Zhuce;
import com.bwie.test.nsgshop.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Denglu extends MyBaseActivity implements Iview{

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.denglu)
    Button denglu;
    @BindView(R.id.zhuce)
    TextView zhuce;
    @BindView(R.id.wang)
    TextView wang;
    @BindView(R.id.zfb)
    ImageView zfb;
    @BindView(R.id.wx)

    ImageView wx;
    String name1;
    String pass1;
    PresentUser pu=new PresentUser(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denglu);
        ButterKnife.bind(this);
        EventBus.getDefault().register(Denglu.this);
    }

    @OnClick({R.id.denglu, R.id.zhuce, R.id.wang})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.denglu:
                name1 = name.getText().toString().trim();
                pass1 = pass.getText().toString().trim();
                if(name1.equals("")||pass1.equals("")||name1==null||pass1==null){
                    Toast.makeText(Denglu.this, "账户名或密码为空，请认真填写", Toast.LENGTH_SHORT).show();
                }else{
                    pu.login(name1,pass1);
                }
                break;
            case R.id.zhuce:
                Intent in=new Intent(Denglu.this,Zhuce.class);
                startActivity(in);
                finish();
                break;
            case R.id.wang:
                break;
        }
    }
    public void cheng(String text,String uid){
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(Denglu.this,"name",name1);
        SharedPreferencesUtils.setParam(Denglu.this,"pass",pass1);
        SharedPreferencesUtils.setParam(Denglu.this,"uid",uid);
        finish();
    }
    public void error(String text){
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void userEventBus(AnyEventType userEvent){
        String name3 = userEvent.getName();
        String pass3 = userEvent.getPass();
        name.setText(name3);
        pass.setText(pass3);
    }
}

