package com.bwie.test.nsgshop.home.present;

import com.bwie.test.nsgshop.home.bean.HomeBean;
import com.bwie.test.nsgshop.home.model.ModelUser;
import com.bwie.test.nsgshop.home.model.Setlist;
import com.bwie.test.nsgshop.home.view.Iview;
import com.bwie.test.nsgshop.home.model.Imodel;

/**
 * Created by admin on 2017/11/9.
 */

public class PresentUser {
    private Imodel imodel;
    private Iview iview;

    public PresentUser(Iview iview) {
        this.iview = iview;
        this.imodel=new ModelUser();
    }
    public void pgetlist(){
        imodel.GetDate(new Setlist() {
            @Override
            public void setlist(HomeBean.DataBean setlismdata) {
                iview.GetDate(setlismdata);
            }
        });
    }
}
