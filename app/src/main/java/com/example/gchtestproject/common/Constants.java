package com.example.gchtestproject.common;

import android.content.Context;

import java.io.File;

public final class Constants {
    public static final String SYSTEM_INIT_FILE_NAME ="gch.android.sysini";
    public static final String FLAG = "com.gch.android";

    public static final String IMAGE_UNSPECIFIED="image/*";
    public static String CACHE_DIR;
    public static String CACHE_DIR_IMAGE;
    public static String CACHE_DIR_UPLOADING_IMG;
    public static String CACHE_IMAGE;
    public static String PHOTO_PATH="handongkeji_android_photo";
    public static String CACHE_VOICE;

    public static void init(Context context){
        CACHE_DIR = context.getCacheDir().getAbsolutePath();
        File file = new File(CACHE_DIR,"image");
        file.mkdirs();
        CACHE_IMAGE = file.getAbsolutePath();
        CACHE_DIR_IMAGE = CACHE_IMAGE;
        file = new File(CACHE_DIR,"temp");
        file.mkdirs();
        CACHE_DIR_UPLOADING_IMG = file.getAbsolutePath();
        file = new File(CACHE_DIR,"voice");
        file.mkdirs();
        CACHE_VOICE = file.getAbsolutePath();
        file = new File(CACHE_DIR,"html");
        file.mkdirs();
        ENVIROMENT_DIR_CACHE = file.getAbsolutePath();
    }
    public static String ENVIROMENT_DIR_CACHE;
    private Constants(){

    }
    public static final int DB_VERSION=1;
    public static final String DB_NAME="android.db";
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
