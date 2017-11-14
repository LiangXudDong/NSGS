package com.bwie.test.nsgshop.home.model;

/**
 * Created by admin on 2017/10/18.
 */

public class User {
    private String img;
    private String title;
    private String data_url;

    public User(String img, String title, String data_url) {
        this.img = img;
        this.title = title;
        this.data_url = data_url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getData_url() {
        return data_url;
    }

    public void setData_url(String data_url) {
        this.data_url = data_url;
    }

    @Override
    public String toString() {
        return "User{" +
                "img='" + img + '\'' +
                ", title='" + title + '\'' +
                ", data_url='" + data_url + '\'' +
                '}';
    }

    public User() {
        super();
    }
}
