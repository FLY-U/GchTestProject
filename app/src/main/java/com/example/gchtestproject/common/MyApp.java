package com.example.gchtestproject.common;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;
import org.xutils.x;
import com.example.gchtestproject.base.BaseActivity;

import java.util.LinkedHashMap;

public class MyApp extends Application {
    public static MyApp instance;
    private LinkedHashMap<String,BaseActivity> activitys = new LinkedHashMap<>();

    @Override
    public void onCreate(){
        super.onCreate();
        if(Build.VERSION.SDK_INT >=Build.VERSION_CODES.N){
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
            builder.detectFileUriExposure();
        }
        instance = this;
        init();
    }
    private void init(){
        Constants.init(this);
        x.Ext.init(this);
    }
    public void openActivity(BaseActivity activity){
        activitys.put(activity.getClass().getSimpleName(),activity);
    }
    public void closeActivity(String activityTAG) {
        BaseActivity baseActivity = activitys.get(activityTAG);
        baseActivity.finish();
        activitys.remove(activityTAG);
    }
    public BaseActivity getActivityByTAG(String TAG) {
        BaseActivity baseActivity = activitys.get(TAG);
        return baseActivity;
    }
    //单例模式中获取唯一的MyApp实例
    public static MyApp getInstance() {
        if (null == instance) {
            instance = new MyApp();
        }
        return instance;
    }
}
