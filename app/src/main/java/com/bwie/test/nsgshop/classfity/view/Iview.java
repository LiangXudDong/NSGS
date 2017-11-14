package com.bwie.test.nsgshop.classfity.view;

import com.bwie.test.nsgshop.classfity.bean.DataleftBean;
import com.bwie.test.nsgshop.classfity.bean.DatarightBean;
import com.bwie.test.nsgshop.classfity.bean.Datebeanitem;

/**
 * Created by admin on 2017/11/8.
 */

public interface Iview {
    void getServerData(DataleftBean dataleftBean,int a);
    void getServerData(Datebeanitem datebeanitem);
    void getServerTypeData(DatarightBean datarightBean);
}
