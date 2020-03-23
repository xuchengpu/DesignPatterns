package com.xcp.designpatterns.adapterpatterns.classadapter;

/**
 * Created by 许成谱 on 2019/3/5 18:26.
 * qq:1550540124
 * 热爱生活每一天！
 * 类适配模式--适配器，只能是具体类
 */
public class VoltAdapter extends Volt220 implements FiveVolt {
    @Override
    public int get5Volt() {
        return getVolt220()/44;//经过这么转换一下，就可以给客户端使用了
    }
}
