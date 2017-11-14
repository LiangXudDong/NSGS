package com.bwie.test.nsgshop.home.model;


import com.bwie.test.nsgshop.home.bean.HomeBean;
import com.bwie.test.nsgshop.utils.ApiServer;
import com.bwie.test.nsgshop.utils.RetroFactory;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/11/8.
 */

public class ModelUser implements Imodel {

    public void GetDate(final Setlist setlist) {
        ApiServer instance = RetroFactory.getInstance();
        Observable<HomeBean> home = instance.getHome();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HomeBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HomeBean homeBean) {
                        HomeBean.DataBean data = homeBean.getData();
                        setlist.setlist(data);
                    }
                });
    }
}
