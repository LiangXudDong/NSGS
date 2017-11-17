package com.bwie.test.nsgshop.register.present;
import com.bwie.test.nsgshop.Login.model.LoginIsOk;
import com.bwie.test.nsgshop.register.model.Imodel;
import com.bwie.test.nsgshop.register.model.ModelUser;
import com.bwie.test.nsgshop.register.model.Zhuc;
import com.bwie.test.nsgshop.register.view.Iview;

/**
 * Created by admin on 2017/11/10.
 */

public class PresentUser {
    private Imodel imodel;
    private Iview iview;
    private com.bwie.test.nsgshop.Login.model.Imodel model;
    public PresentUser(Iview iview) {
        this.iview = iview;
        this.imodel = new ModelUser();
        this.model=new com.bwie.test.nsgshop.Login.model.ModelUser();
    }

    public void Zhuce(String name, String pass) {
        imodel.initData(name, pass, new Zhuc() {
            @Override
            public void setzhl(String code, String msg) {
                if (code.equals("0")) {
                    iview.zcheng(msg);
                } else {
                    iview.zerror(msg);
                }
            }
        });
    }
    public void login(String name1,String pass1){
        model.initData(name1, pass1, new LoginIsOk() {
            @Override
            public void loginIsOk(String code, String mag, String uid) {
                if(code.equals("0")) {
                    iview.cheng(mag,uid);
                }else{
                    iview.error(mag);
                }
            }
        });
    }
}

