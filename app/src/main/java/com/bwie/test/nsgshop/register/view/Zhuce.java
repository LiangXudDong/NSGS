package com.bwie.test.nsgshop.register.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.test.nsgshop.Login.view.AnyEventType;
import com.bwie.test.nsgshop.R;
import com.bwie.test.nsgshop.base.MyBaseActivity;
import com.bwie.test.nsgshop.register.present.PresentUser;
import com.bwie.test.nsgshop.utils.SharedPreferencesUtils;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Zhuce extends MyBaseActivity implements Iview, com.bwie.test.nsgshop.Login.view.Iview{

    @BindView(R.id.name)
    EditText name;
    @BindView(R.id.pass)
    EditText pass;
    @BindView(R.id.zhuce)
    Button zhuce;
    @BindView(R.id.denglu)
    TextView denglu;
    @BindView(R.id.fan)
    TextView fan;
    String name1;
    String pass1;
    String y;
    PresentUser pu=new PresentUser(this);
    com.bwie.test.nsgshop.Login.present.PresentUser pul=new com.bwie.test.nsgshop.Login.present.PresentUser(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.zhuce, R.id.denglu, R.id.fan})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.zhuce:
                name1 = name.getText().toString().trim();
                pass1 = pass.getText().toString().trim();
                if (name1.equals("") || pass1.equals("") || name1 == null || pass1 == null) {
                    Toast.makeText(Zhuce.this, "账户名或密码为空，请认真填写", Toast.LENGTH_SHORT).show();
                } else {
                   pu.Zhuce(name1,pass1);
                }
                break;
            case R.id.denglu:
                name1 = name.getText().toString().trim();
                pass1 = pass.getText().toString().trim();
                if(name1.equals("")||pass1.equals("")||name1==null||pass1==null){
                    Toast.makeText(Zhuce.this, "账户名或密码为空，请认真填写", Toast.LENGTH_SHORT).show();
                }else{
                    pul.login(name1,pass1);
                }
                break;
            case R.id.fan:
                EventBus.getDefault().post(new AnyEventType(name1,pass1));
                finish();
                break;
        }
    }

    @Override
    public void cheng(String text, String uid) {
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
        SharedPreferencesUtils.setParam(Zhuce.this,"name",name1);
        SharedPreferencesUtils.setParam(Zhuce.this,"pass",pass1);
        SharedPreferencesUtils.setParam(Zhuce.this,"uid",uid);
        finish();
    }

    @Override
    public void error(String text) {
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void zcheng(String text) {
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void zerror(String text) {
        Toast.makeText(this,text, Toast.LENGTH_SHORT).show();
    }
}
