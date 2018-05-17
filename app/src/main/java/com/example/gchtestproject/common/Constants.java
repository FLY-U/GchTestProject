package com.example.gchtestproject.common;

import android.content.Context;

import java.io.File;

public final class Constants {
    public static final String SYSTEM_INIT_FILE_NAME ="gch.android.sysini";//系统默认文件名
    public static final String FLAG = "com.gch.android";//

    public static final String IMAGE_UNSPECIFIED="image/*";//未指明的图片格式
    public static String CACHE_DIR;
    public static String CACHE_DIR_IMAGE;
    public static String CACHE_DIR_UPLOADING_IMG;
    public static String CACHE_IMAGE;
    public static String PHOTO_PATH="handongkeji_android_photo";
    public static String CACHE_VOICE;

    public static void init(Context context){
        CACHE_DIR = context.getCacheDir().getAbsolutePath();//方法用于获取/data/data/<application package>/cache目录
        /*在 /data/data/<application package>/cache目录创建image的子文件夹*/
        File file = new File(CACHE_DIR,"image");
        file.mkdirs();
        /*获取图片的缓存目录*/
        CACHE_IMAGE = file.getAbsolutePath();
        CACHE_DIR_IMAGE = CACHE_IMAGE;
        /* 在/data/data/<application package>/cache目录创建temp的子文件夹*/
        file = new File(CACHE_DIR,"temp");
        file.mkdirs();
        CACHE_DIR_UPLOADING_IMG = file.getAbsolutePath();//上传图片的临时目录
        file = new File(CACHE_DIR,"voice");/* 在/data/data/<application package>/cache目录创建voice的子文件夹*/
        file.mkdirs();
        CACHE_VOICE = file.getAbsolutePath();//获取voice的绝对路径
        file = new File(CACHE_DIR,"html");//创建html的文件夹
        file.mkdirs();
        ENVIROMENT_DIR_CACHE = file.getAbsolutePath();
    }
    public static String ENVIROMENT_DIR_CACHE;
    private Constants(){

    }
    public static final int DB_VERSION=1;//数据库版本号初始未1
    public static final String DB_NAME="android.db";//数据库名称
    public static final String URL_CONTEXTPATH="http://app.newtonapple.cn/zhangyiyan/";
    //微信支付回调url(掌一眼中未用此地址)
    public static String wxUrl =URL_CONTEXTPATH+
            "wxpay/getnotify.json";

    //微信下单(掌一眼)
    public static String wxOrder =URL_CONTEXTPATH+
            "wxpay/auth/placeOrder.json";

    //第三方登录(掌一眼)
    public static final String URL_SAN_FANG_DENG_LU = URL_CONTEXTPATH +
            "mbuser/loginByOpenNew.json";

    //大家看列表(掌一眼)
    public static final String URL_DA_JIA_LIE_BIAO = URL_CONTEXTPATH +
            "look/looklist.json";

}
