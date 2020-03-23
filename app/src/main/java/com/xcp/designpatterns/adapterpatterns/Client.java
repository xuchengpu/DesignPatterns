package com.xcp.designpatterns.adapterpatterns;

import com.xcp.designpatterns.adapterpatterns.classadapter.VoltAdapter;
import com.xcp.designpatterns.adapterpatterns.instanceadapter.Volt220;

/**
 * Created by 许成谱 on 2019/3/5 18:35.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class Client {
    public static void main(String[] args){
        //类适配器模式调用
        VoltAdapter classVoltAdapter = new VoltAdapter();
        int classVolt = classVoltAdapter.get5Volt();
        System.out.println("类适配器模式调用电压为："+classVolt+"V");
        //对象适配器模式的调用
        Volt220 instanceVolt220 = new Volt220();
        com.xcp.designpatterns.adapterpatterns.instanceadapter.VoltAdapter instanceAdapter=new com.xcp.designpatterns.adapterpatterns.instanceadapter.VoltAdapter(instanceVolt220);
        int instanceVolt = instanceAdapter.get5Volt();
        System.out.println("对象适配器模式的调用电压为："+instanceVolt+"V");
    }
}
