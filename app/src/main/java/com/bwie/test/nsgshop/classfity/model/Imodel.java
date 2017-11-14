package com.bwie.test.nsgshop.classfity.model;

/**
 * Created by admin on 2017/11/8.
 */

public interface Imodel {
    void GetDate(String gc_id,final SetGridlist setlist);
    void GetliftDate(final SetleftList setliftlist);
    void GetitemDate(final Setitembean setitembean);
    void GetrightDate(String gi,final SetRightlist setRightlist);
}
