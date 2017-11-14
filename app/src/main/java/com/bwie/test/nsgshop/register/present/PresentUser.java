package com.bwie.test.nsgshop.register.present;

import com.bwie.test.nsgshop.Login.model.LoginIsOk;
import com.bwie.test.nsgshop.register.model.Imodel;
import com.bwie.test.nsgshop.register.model.ModelUser;
import com.bwie.test.nsgshop.register.view.Iview;

/**
 * Created by admin on 2017/11/10.
 */

public class PresentUser {
    private Imodel imodel;
    private Iview iview;

    public PresentUser(Iview iview) {
        this.iview = iview;
        this.imodel=new ModelUser();
    }
    public void Zhuce(String name,String pass){
        imodel.initData(name, pass, new LoginIsOk() {
            @Override
            public void loginIsOk(String code, String mag) {
                if(code.equals("0")){
                    iview.zcheng(mag);
                }else{
                    iview.zerror(mag);
                }
            }
        });
    }
}
