package com.bwie.test.nsgshop.cart.present;

import android.util.Log;

import com.bwie.test.nsgshop.cart.bean.CartBean;
import com.bwie.test.nsgshop.cart.model.Getgclist;
import com.bwie.test.nsgshop.cart.model.Imodel;
import com.bwie.test.nsgshop.cart.model.ModelUser;
import com.bwie.test.nsgshop.cart.view.Iview;

/**
 * Created by admin on 2017/11/10.
 */

public class PresentUser {
    private Imodel imodel;
    private Iview ivew;

    public PresentUser(Iview ivew) {
        this.ivew = ivew;
        this.imodel=new ModelUser();
    }
    public void getgclist(String uid){
        Log.d("MAIn", "getgclist: "+"---+++===");
        Log.d("MAIn", "getgclist: "+"---+++==="+uid);
        imodel.initData(uid, new Getgclist() {
            @Override
            public void getgclist(CartBean cartBean) {
                Log.d("MAIn", "getgclist: "+"---+++---");
//                Log.d("MAIn", "getgclist: "+""+cartBean.getData().get(1).getList().get(1).getTitle());
                ivew.gegclist(cartBean);

            }
        });
    }
}
