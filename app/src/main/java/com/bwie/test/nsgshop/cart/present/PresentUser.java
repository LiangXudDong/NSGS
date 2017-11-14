package com.bwie.test.nsgshop.cart.present;

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

}
