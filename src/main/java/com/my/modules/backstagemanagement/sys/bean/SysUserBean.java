package com.my.modules.backstagemanagement.sys.bean;

import com.my.common.bean.DataEntity;

/**
 * Created by lenovo on 2017/8/24.
 */
public class SysUserBean extends DataEntity{

    private String username;
    private String password;
    private String photo;
    private String loginIp;
    private String name;
    //角色列表数组
    //private String []roleAttr;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
