package com.bwie.test.nsgshop.Login.view;

/**
 * Created by admin on 2017/11/14.
 */

public class AnyEventType {
    private String name;
    private String pass;

    public AnyEventType(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
