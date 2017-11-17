package com.bwie.test.nsgshop.liebiao.Presenter;

import com.bwie.test.nsgshop.liebiao.bean.Shangpinl;
import com.bwie.test.nsgshop.liebiao.model.Imodel;
import com.bwie.test.nsgshop.liebiao.model.ModelUser;
import com.bwie.test.nsgshop.liebiao.model.Setshangpinl;
import com.bwie.test.nsgshop.liebiao.view.Iview;

/**
 * Created by admin on 2017/11/16.
 */

public class Presenter {
    private Imodel imodel;
    private Iview iview;

    public Presenter(Iview iview) {
        this.iview = iview;
        this.imodel=new ModelUser();
    }
    public void setlist(String posit){
        imodel.initData(posit, new Setshangpinl() {
            @Override
            public void setShangpinl(Shangpinl shangpinl) {
                iview.setAdapter(shangpinl);
            }
        });
    }
}
