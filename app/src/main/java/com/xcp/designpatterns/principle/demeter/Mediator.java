package com.xcp.designpatterns.principle.demeter;

import android.util.Log;

import com.xcp.designpatterns.principle.none.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 许成谱 on 2018/10/23 11:48.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class Mediator {
    List<Room> mRooms=new ArrayList<>();
    public Mediator(){
        for(int i = 0; i < 5; i++) {
            mRooms.add(new Room(14+i,(14+i)*150));
        }
    }

    /**
     * 租房出去的行为
     * @param roomArea
     * @param roomPrice
     */
    public Room rentOut(float roomArea, float roomPrice){
        for(int i = 0; i < mRooms.size(); i++) {
            if(isSuitable(roomArea,roomPrice,mRooms.get(i))) {
                Log.e("TAG", "租到房啦"+mRooms.get(i));
                return mRooms.get(i);
            }
        }
        return null;
    }
    private boolean isSuitable(float roomArea, float roomPrice, Room room) {
        return room.price<=roomPrice&&roomArea>=room.area;
    }
}
