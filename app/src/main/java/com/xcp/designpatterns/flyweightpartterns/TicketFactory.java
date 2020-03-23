package com.xcp.designpatterns.flyweightpartterns;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by 许成谱 on 2019/6/26 15:02.
 * qq:1550540124
 * 热爱生活每一天！
 * 享元对象工厂类
 */
public class TicketFactory {
    private static Map<String, TrainTicket> sTickets = new ConcurrentHashMap();

    public static TrainTicket getTicket(String from, String to) {
        String key = from + "-" + to;
        if (sTickets.containsKey(key)) {
            System.out.println("从缓存中拿对象：key="+key);
            return sTickets.get(key);
        } else {
            TrainTicket trainTicket = new TrainTicket(from, to);
            sTickets.put(key,trainTicket);
            System.out.println("new对象：key="+key);
            return trainTicket;
        }
    }
}
