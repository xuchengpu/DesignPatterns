package com.xcp.designpatterns.principle.none;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2018/10/23 11:40.
 * qq:1550540124
 * 热爱生活每一天！
 * 中介
 */
public class Mediator {
    List<Room> mRooms=new ArrayList<>();
    public Mediator(){
        for(int i = 0; i < 5; i++) {
          mRooms.add(new Room(14+i,(14+i)*150));
        }
    }

    public List<Room> getAllRooms() {
        return mRooms;
    }
}
