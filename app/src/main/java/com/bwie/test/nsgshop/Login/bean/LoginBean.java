package com.bwie.test.nsgshop.Login.bean;

/**
 * Created by admin on 2017/11/10.
 */

public class LoginBean {
    /**
     * msg : 登录成功
     * code : 0
     * data : {"age":null,"appkey":null,"appsecret":null,"createtime":"2017-11-10T13:19:44","email":null,"gender":0,"icon":null,"mobile":"13512344321","money":0,"nickname":null,"password":"123456","token":"082DB28BFE184920B57B3FE4DBBF8B8E","uid":926,"username":"13512344321"}
     */

    private String msg;
    private String code;
    private DataBean data;

    @Override
    public String toString() {
        return "LoginBean{" +
                "msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * age : null
         * appkey : null
         * appsecret : null
         * createtime : 2017-11-10T13:19:44
         * email : null
         * gender : 0
         * icon : null
         * mobile : 13512344321
         * money : 0
         * nickname : null
         * password : 123456
         * token : 082DB28BFE184920B57B3FE4DBBF8B8E
         * uid : 926
         * username : 13512344321
         */

        private Object age;
        private Object appkey;
        private Object appsecret;
        private String createtime;
        private Object email;
        private int gender;
        private Object icon;
        private String mobile;
        private int money;
        private Object nickname;
        private String password;
        private String token;
        private int uid;
        private String username;

        public Object getAge() {
            return age;
        }

        public void setAge(Object age) {
            this.age = age;
        }

        public Object getAppkey() {
            return appkey;
        }

        public void setAppkey(Object appkey) {
            this.appkey = appkey;
        }

        public Object getAppsecret() {
            return appsecret;
        }

        public void setAppsecret(Object appsecret) {
            this.appsecret = appsecret;
        }

        public String getCreatetime() {
            return createtime;
        }

        public void setCreatetime(String createtime) {
            this.createtime = createtime;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public Object getNickname() {
            return nickname;
        }

        public void setNickname(Object nickname) {
            this.nickname = nickname;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
