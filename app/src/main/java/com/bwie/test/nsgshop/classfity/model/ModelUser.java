package com.bwie.test.nsgshop.classfity.model;

import android.util.Log;

import com.bwie.test.nsgshop.classfity.bean.DataleftBean;
import com.bwie.test.nsgshop.classfity.bean.DatarightBean;
import com.bwie.test.nsgshop.classfity.bean.DateGridBean;
import com.bwie.test.nsgshop.classfity.bean.Datebeanitem;
import com.bwie.test.nsgshop.utils.ApiServer;
import com.bwie.test.nsgshop.utils.RetroFactory03;

import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by admin on 2017/11/8.
 */

public class ModelUser implements Imodel {
    public void GetDate(String gc_id,final SetGridlist setlist) {
        ApiServer instance = RetroFactory03.getInstance();
        Observable<DateGridBean> home = instance.getgrid(gc_id);
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DateGridBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DateGridBean dateGridBean) {
                        setlist.getGridList(dateGridBean);
                    }
                });
    }
    public void GetliftDate(final SetleftList setliftlist) {
        ApiServer instance = RetroFactory03.getInstance();
        Observable<DataleftBean > home = instance.getleft();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DataleftBean>() {
                    @Override
                    public void onCompleted() {
                        Log.d("Maina","onCompleted");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("Maina","onError");
                    }

                    @Override
                    public void onNext(DataleftBean dataleftBean) {
                        Log.d("Maina","Onnext");
                        setliftlist.setliftlist(dataleftBean);
                    }
                });
    }
    public void GetitemDate(final Setitembean setitembean) {
        ApiServer instance = RetroFactory03.getInstance();
        Observable<Datebeanitem> home = instance.getitem();
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Datebeanitem>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Datebeanitem datebeanitem) {
                        setitembean.setitembean(datebeanitem);
                    }
                });
    }
    public void GetrightDate(String gi,final SetRightlist setRightlist) {
        ApiServer instance = RetroFactory03.getInstance();
        Observable<DatarightBean> home = instance.getreight(gi);
        home.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DatarightBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DatarightBean datarightBean) {
                        setRightlist.setliftlist(datarightBean);
                    }
                });
    }
}
