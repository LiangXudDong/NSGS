package com.bwie.test.nsgshop.Login.present;

import com.bwie.test.nsgshop.Login.model.Imodel;
import com.bwie.test.nsgshop.Login.model.LoginIsOk;
import com.bwie.test.nsgshop.Login.model.ModelUser;
import com.bwie.test.nsgshop.Login.view.Iview;

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
    public void login(String name,String pass){
        imodel.initData(name, pass, new LoginIsOk() {

            @Override
            public void loginIsOk(String code, String mag) {
                if(code.equals("0")){
                    iview.cheng(mag);
                }else{
                    iview.error(mag);
                }
            }
        });

    }
}
