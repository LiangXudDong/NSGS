package com.bwie.test.nsgshop.register.model;

import com.bwie.test.nsgshop.Login.model.LoginIsOk;
import com.bwie.test.nsgshop.register.bean.RegisterBean;
import com.bwie.test.nsgshop.utils.ApiServer;
import com.bwie.test.nsgshop.utils.RetroFactory02;

import java.util.HashMap;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/11/10.
 */

public class ModelUser implements Imodel{

    private HashMap<String, String> map;

    public void initData(String name, String pass, final Zhuc lk){
        map = new HashMap();
        map.put("mobile",name);
        map.put("password",pass);
        ApiServer instance = RetroFactory02.getInstance();
        Observable<RegisterBean> setname = instance.zhuce(map);
        setname.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RegisterBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(RegisterBean registerBean) {
                        String code = registerBean.getCode();
                        String msg = registerBean.getMsg();
                        lk.setzhl(code,msg);
                    }
                });
    }
}
