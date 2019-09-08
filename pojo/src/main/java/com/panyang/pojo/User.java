package com.panyang.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private String username;
    private String password;
    private Integer age;
    private Date createTime;

    public User() {
    }

    public User(String username, String password, Integer age, Date createTime) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.createTime = createTime;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", createTime=" + createTime +
                '}';
    }
}
