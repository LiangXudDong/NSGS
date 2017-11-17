package com.bwie.test.nsgshop.Login.model;

import android.util.Log;

import com.bwie.test.nsgshop.Login.bean.LoginBean;
import com.bwie.test.nsgshop.utils.ApiServer;
import com.bwie.test.nsgshop.utils.RetroFactory02;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/11/10.
 */

public class ModelUser implements Imodel{

    public void initData(String name, String pass, final LoginIsOk lk){
        ApiServer instance = RetroFactory02.getInstance();
        Observable<LoginBean> setname = instance.setname(name,pass);
        setname.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(LoginBean loginBean) {
                        Log.d("maina",loginBean.toString());
                        String code = loginBean.getCode();
                        lk.loginIsOk(code,loginBean.getMsg(),loginBean.getData().getUid()+"");
                    }
                });
    }
}
