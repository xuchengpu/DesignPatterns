package com.xcp.designpatterns.principle.demeter;

import android.util.Log;


/**
 * Created by 许成谱 on 2018/10/23 11:53.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class Tenant {

    public void rentRoom(float roomArea,float roomPrice,Mediator mediator){
        Log.e("TAG", "租到房啦"+mediator.rentOut(roomArea,roomPrice));
    }
}
