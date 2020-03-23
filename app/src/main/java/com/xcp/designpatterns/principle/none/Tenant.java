package com.xcp.designpatterns.principle.none;

import android.util.Log;

import java.util.List;

/**
 * Created by 许成谱 on 2018/10/23 11:42.
 * qq:1550540124
 * 热爱生活每一天！
 * 租户
 */
public class Tenant {

    public void rentRoom(float roomArea,float roomPrice,Mediator mediator){
        List<Room> rooms = mediator.getAllRooms();
        for(int i = 0; i < rooms.size(); i++) {
          if(isSuitable(roomArea,roomPrice,rooms.get(i))) {
              Log.e("TAG", "租到房啦"+rooms.get(i));
              break;
          }
        }
    }

    private boolean isSuitable(float roomArea, float roomPrice, Room room) {
        return room.price<=roomPrice&&roomArea>=room.area;
    }
}
