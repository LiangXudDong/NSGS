package com.bwie.test.nsgshop.xiangqing.presenter;

import android.util.Log;

import com.bwie.test.nsgshop.xiangqing.bean.JIarugouwuche;
import com.bwie.test.nsgshop.xiangqing.bean.Shangpinlx;
import com.bwie.test.nsgshop.xiangqing.model.AddsortInterFace;
import com.bwie.test.nsgshop.xiangqing.model.Imodel;
import com.bwie.test.nsgshop.xiangqing.model.ModelUser;
import com.bwie.test.nsgshop.xiangqing.model.SetXlist;
import com.bwie.test.nsgshop.xiangqing.view.Iview;

/**
 * Created by admin on 2017/11/16.
 */

public class Presentuser {
    private Imodel imodel;
    private Iview iview;

    public Presentuser(Iview iview) {
        this.iview = iview;
        this.imodel=new ModelUser();
    }
    public void setAdapter(String pid){
        Log.d("MAIn", "setAdapter:"+pid);
        imodel.initData(pid, new SetXlist() {
            @Override
            public void setxlixt(Shangpinlx shangpinx) {
                Log.d("MAIn", "setxlixt:");
                Log.d("MAIn", "setxlixt: "+shangpinx.getData().getTitle());
               iview.setAdapter(shangpinx);
            }
        });
    }
    public void isadd(String uid,String pid,String sellerid){
        imodel.setgouwu(uid, pid, sellerid, new AddsortInterFace() {
            @Override
            public void setaddcart(JIarugouwuche jIarugouwuche) {
                if(jIarugouwuche.equals("0")){
                    iview.addsf(jIarugouwuche.getMsg());
                }else{
                    iview.bad(jIarugouwuche.getMsg());
                }
            }
        });
    }
}
