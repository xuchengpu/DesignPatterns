package com.xcp.designpatterns.iteratorpattern.iterator;

/**
 * Created by 许成谱 on 2019/6/19 10:58.
 * qq:1550540124
 * 热爱生活每一天！
 * 迭代器模式：提供一种方法顺序访问一个容器中的各个元素，而又不需要暴露该对象的内部表示
 *
 * 本例中减少了一个查询方法，这一切都交由第三者iterator来实现，影藏了查询子元素实现的细节。WXSystem、QQSystem内部究竟是数组还是集合来装用户信息的，
 * 对于查询者并不知道。他们之间的交接是通过一个第三者iterator来实现的。
 */
public class Client {
    public static void main(String[] args) {
        WXSystem wxSystem = new WXSystem();
        QQSystem qqSystem = new QQSystem();

        UserInfo userInfo = queryUserInfo(wxSystem.iterator(),"张三", "123456");
        if (userInfo == null) {
            userInfo = queryUserInfo(qqSystem.iterator(),"张三", "123456");
        }
        if (userInfo == null) {
            //登录失败
        }

    }

    private static UserInfo queryUserInfo(IIterator<UserInfo> iterator,String name,String password) {
        while (iterator.hasNext()){
            UserInfo userInfo = iterator.next();
            if (userInfo.getmName().equals(name) && userInfo.getmPassWord().equals(password)) {
                return userInfo;
            }
        }
        return null;
    }
}
