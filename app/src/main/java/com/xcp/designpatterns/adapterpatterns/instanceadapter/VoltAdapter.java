package com.xcp.designpatterns.adapterpatterns.instanceadapter;

/**
 * Created by 许成谱 on 2019/3/5 18:26.
 * qq:1550540124
 * 热爱生活每一天！
 * 对象适配器模式--适配器，只能是具体类
 */
public class VoltAdapter  implements FiveVolt {

    private  Volt220 volt220;

    public VoltAdapter(Volt220 volt220) {
        this.volt220=volt220;
    }

    @Override
    public int get5Volt() {
        return volt220.getVolt220()/44;//经过这么转换一下，就可以给客户端使用了
    }

    public int getVolt220(){
        return volt220.getVolt220();
    }
}
