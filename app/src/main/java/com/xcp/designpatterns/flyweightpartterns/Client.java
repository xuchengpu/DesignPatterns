package com.xcp.designpatterns.flyweightpartterns;

/**
 * Created by 许成谱 on 2019/6/26 14:48.
 * qq:1550540124
 * 热爱生活每一天！
 * 享元设计模式客户端
 * 用于可能存在大量重复对象，缓存这类对象，避免重复创建，节省开销，减少内存使用量提高性能
 * 角色：
 * 享元工厂类、享元对象抽象类、具体享元对象类
 */
public class Client {
    public static void main(String[] args){
       TicketFactory.getTicket("北京","乌兰布统").showTicketInfo("硬座");
       TicketFactory.getTicket("北京","乌兰布统").showTicketInfo("软座");
       TicketFactory.getTicket("北京","乌兰布统").showTicketInfo("硬卧");
       TicketFactory.getTicket("北京","锡林郭勒").showTicketInfo("硬座");
    }
}
