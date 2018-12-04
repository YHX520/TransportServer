package com.huaxuan.imageserver.unit;

public class SystemParameter {

    static String photoDir = null;
    public static final String imagePath =getRelavitePath()+"\\test\\photo\\";

    private static String getRelavitePath() {
        if (photoDir == null) {
           photoDir=System.getProperty("user.dir");
        }
        return photoDir;
    }
}
