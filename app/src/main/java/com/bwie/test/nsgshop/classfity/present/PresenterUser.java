package com.bwie.test.nsgshop.classfity.present;

import android.util.Log;

import com.bwie.test.nsgshop.classfity.bean.DataleftBean;
import com.bwie.test.nsgshop.classfity.bean.DatarightBean;
import com.bwie.test.nsgshop.classfity.bean.Datebeanitem;
import com.bwie.test.nsgshop.classfity.model.Imodel;
import com.bwie.test.nsgshop.classfity.model.ModelUser;
import com.bwie.test.nsgshop.classfity.model.SetRightlist;
import com.bwie.test.nsgshop.classfity.model.Setitembean;
import com.bwie.test.nsgshop.classfity.model.SetleftList;
import com.bwie.test.nsgshop.classfity.view.Iview;

/**
 * Created by admin on 2017/11/13.
 */

public class PresenterUser {
    private Imodel imodel;
    private Iview iview;

    public PresenterUser(Iview iview) {
        this.iview = iview;
        imodel = new ModelUser();
    }

    public void setliftadapter() {
        imodel.GetliftDate(new SetleftList() {
            @Override
            public void setliftlist(DataleftBean dataleftBean) {
                Log.d("Maina","s2"+dataleftBean.getDatas().getClass_list().get(0).getGc_name());
                iview.getServerData(dataleftBean,1);
            }
        });
    }
    public void setitemadapter(){
        imodel.GetitemDate(new Setitembean() {
            @Override
            public void setitembean(Datebeanitem datebeanitem) {
                iview.getServerData(datebeanitem);
            }
        });
    }
    public void setrightdapter(String i){
        imodel.GetrightDate(i, new SetRightlist() {
            @Override
            public void setliftlist(DatarightBean datarightBean) {
                iview.getServerTypeData(datarightBean);
            }
        });

    }
}
