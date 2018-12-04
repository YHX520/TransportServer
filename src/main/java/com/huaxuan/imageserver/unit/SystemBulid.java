package com.huaxuan.imageserver.unit;

import com.huaxuan.imageserver.logtool.L;

import java.util.Random;

/**
 * Created by huaxuan on 2018/10/13.
 */

public class SystemBulid {


    //创建msgID= 时间戳+3位随机数
    static public  String BulidMsgId(){
        Random random=new Random();
        StringBuilder id= new StringBuilder(System.currentTimeMillis() + "");
        for(int i=0;i<4;i++){
            id.append(random.nextInt(10));
        }
        L.i(id.toString());
        return id.toString();
    }
}
