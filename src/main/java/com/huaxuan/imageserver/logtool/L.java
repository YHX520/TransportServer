package com.huaxuan.imageserver.logtool;

public class L {
    private static boolean DEBUG = true;
  public  static void i(String log){

        if(DEBUG) {
           System.out.println("普通日志" + log);
       }
   }
}
