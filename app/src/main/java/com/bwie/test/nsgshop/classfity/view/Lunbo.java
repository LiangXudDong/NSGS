package com.bwie.test.nsgshop.classfity.view;

/**
 * Created by admin on 2017/10/18.
 */

public class Lunbo {
    private String img;
    private String data;

    public Lunbo(String img, String data) {
        this.img = img;
        this.data = data;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Lunbo{" +
                "img='" + img + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public Lunbo() {
        super();
    }
}
