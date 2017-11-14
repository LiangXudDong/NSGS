package com.bwie.test.nsgshop;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * Created by admin on 2017/11/9.
 */

public class MyApp extends Application {
    public static MyApp mInstance;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mInstance = this;
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
}
