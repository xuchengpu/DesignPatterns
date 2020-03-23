package com.xcp.designpatterns.observerpatterns;

/**
 * Created by 许成谱 on 2019/3/7 14:42.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class UserInfo {
    private String name;
    private String age;

    public UserInfo() {
    }

    public UserInfo(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
