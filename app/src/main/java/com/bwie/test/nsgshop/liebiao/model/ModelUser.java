package com.bwie.test.nsgshop.liebiao.model;

import com.bwie.test.nsgshop.liebiao.bean.Shangpinl;
import com.bwie.test.nsgshop.utils.ApiServer;
import com.bwie.test.nsgshop.utils.RetroFactory02;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/11/16.
 */

public class ModelUser implements Imodel{
    public void initData(String posit,final Setshangpinl ss) {
        ApiServer instance = RetroFactory02.getInstance();
        final Observable<Shangpinl> setname = instance.getshangpl(posit);
        setname.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shangpinl>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Shangpinl shangpinl) {
                        ss.setShangpinl(shangpinl);
                    }
                });
    }
}
