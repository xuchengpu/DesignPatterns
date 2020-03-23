package com.xcp.designpatterns.flyweightpartterns;

import java.util.Random;

/**
 * Created by 许成谱 on 2019/6/26 14:56.
 * qq:1550540124
 * 热爱生活每一天！
 * 具体享元对象
 */
public class TrainTicket implements ITicket {
    public String from;//出发地
    public String to;//目的地
    public String bunk;//席位
    public int price;//价格

    public TrainTicket(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void showTicketInfo(String bunk) {
        System.out.println("从"+from+"到"+to+"的"+bunk+"价格是"+new Random().nextInt(200));
    }
}
