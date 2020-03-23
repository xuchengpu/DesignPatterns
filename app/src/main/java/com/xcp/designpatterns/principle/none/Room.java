package com.xcp.designpatterns.principle.none;

/**
 * Created by 许成谱 on 2018/10/23 11:39.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class Room {
     public float area;
    public float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "area=" + area +
                ", price=" + price +
                '}';
    }
}
