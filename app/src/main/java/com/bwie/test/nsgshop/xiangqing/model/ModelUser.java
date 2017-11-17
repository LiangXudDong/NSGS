package com.bwie.test.nsgshop.xiangqing.model;

import com.bwie.test.nsgshop.utils.ApiServer;
import com.bwie.test.nsgshop.utils.RetroFactory02;
import com.bwie.test.nsgshop.xiangqing.bean.JIarugouwuche;
import com.bwie.test.nsgshop.xiangqing.bean.Shangpinlx;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/11/16.
 */

public class ModelUser implements Imodel{
    public void initData(String posit,final SetXlist ss) {
        ApiServer instance = RetroFactory02.getInstance();
        Observable<Shangpinlx> setname = instance.getshangplx(posit);
        setname.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Shangpinlx>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Shangpinlx shangpinx) {
                        ss.setxlixt(shangpinx);
                    }
                });
    }
    public void setgouwu(String uid,String pid,String sellerid,final AddsortInterFace ai) {
        ApiServer instance = RetroFactory02.getInstance();
        Observable<JIarugouwuche> setname = instance.setgc(uid,pid,sellerid);
        setname.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JIarugouwuche>() {
                    @Override
                    public void onCompleted() {

                    }
                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(JIarugouwuche jIarugouwuche) {
                        ai.setaddcart(jIarugouwuche);
                    }
                });
    }
}
