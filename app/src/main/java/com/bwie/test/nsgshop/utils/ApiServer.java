package com.bwie.test.nsgshop.utils;


import com.bwie.test.nsgshop.Login.bean.LoginBean;
import com.bwie.test.nsgshop.classfity.bean.DataleftBean;
import com.bwie.test.nsgshop.classfity.bean.DatarightBean;
import com.bwie.test.nsgshop.classfity.bean.DateGridBean;
import com.bwie.test.nsgshop.classfity.bean.Datebeanitem;
import com.bwie.test.nsgshop.home.bean.HomeBean;
import com.bwie.test.nsgshop.register.bean.RegisterBean;

import java.util.HashMap;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by fan on 2017/11/8.
 */

public interface ApiServer {

    @GET("umIPmfS6c83237d9c70c7c9510c9b0f97171a308d13b611?uri=homepage")
    Observable<HomeBean> getHome();
    @GET("user/login")
    Observable<LoginBean> setname(@Query("mobile") String name, @Query("password") String pass);
    @POST("user/reg")
    Observable<RegisterBean> zhuce(@QueryMap HashMap<String,String> map);
    @GET("mobile/index.php?act=goods_class")
    Observable<DateGridBean> getgrid(@Query("gc_id") String k);
    @GET("mobile/index.php?act=goods_class")
    Observable<DataleftBean> getleft();
    @GET("mobile/index.php?act=goods_class")
    Observable<Datebeanitem> getitem();
    @GET("mobile/index.php?act=goods_class")
    Observable<DatarightBean> getreight(@Query("gc_id") String i);
}
