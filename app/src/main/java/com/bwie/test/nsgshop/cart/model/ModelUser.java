package com.bwie.test.nsgshop.cart.model;


import android.util.Log;

import com.bwie.test.nsgshop.cart.bean.CartBean;
import com.bwie.test.nsgshop.utils.ApiServer;
import com.bwie.test.nsgshop.utils.RetroFactory02;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/11/8.
 */

public class ModelUser implements Imodel {
    public void initData(String uid,final Getgclist ss) {
        ApiServer instance = RetroFactory02.getInstance();
        Observable<CartBean> setname = instance.getgc();
        setname.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CartBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("MAINA", "onCompleted: ");
                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        Log.d("MAINA", "onError: ");
                        Log.d("66666",e.getMessage());
                    }

                    @Override
                    public void onNext(CartBean cartBean) {
                        Log.d("MAINA", "onNext: ");
//                        Log.d("MAINA", "onNext: "+cartBean.getData().get(1).getList().get(1).getTitle());
                        ss.getgclist(cartBean);
                    }
                });
    }
}
