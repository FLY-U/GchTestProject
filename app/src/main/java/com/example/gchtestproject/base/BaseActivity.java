package com.example.gchtestproject.base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.Window;

import com.blankj.utilcode.util.Utils;
import com.example.gchtestproject.common.MyApp;
import com.example.gchtestproject.dialog.ProgressDialog;
import com.example.gchtestproject.utils.SPUtils;
import com.example.gchtestproject.utils.SystemDialogUtils;

public class BaseActivity extends AppCompatActivity {
    public MyApp myApp;
    public ProgressDialog progressDialog; //初始化加载框
    public SPUtils spUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//改变屏幕显示方式 横屏或者竖屏
        if (Build.VERSION.SDK_INT/*获取当前系统的SDK版本号*/ >= Build.VERSION_CODES.LOLLIPOP/*目前已知的SDK版本号的枚举类*/) {
            initenimate();
        }
        myApp = (MyApp) getApplicationContext();//不理解
        myApp.openActivity(this);
        initSp(); //初始化Sp
    }

    private void initSp() {
        Utils.init(this);//初始化工具类Utils
        spUtils = SPUtils.getInstance("TestProject");//获取SPUtils 的实例，有些不理解？
    }

    public void dialogShow(String message) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMsg(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }

    public void dialogShow() {
        dialogShow("加载中...");
    }

    public void dialogDismiss() {
        progressDialog.dismiss();
    }
    public void dialogComplete(ProgressDialog.OnCompleteListener listener, String complMessage) {
        progressDialog.complete(listener, complMessage);
    }
    //    Lollipop 中Activity和 Fragment的过渡动画是基于 Android一个叫作 Transition 的新特性实现的。
//    初次引入这个特性是在 KitKat 中，Transition 框架提供了一个方便的 API 来构建应用中不同 UI 状态切换时的动画。
//    这个框架始终围绕两个关键概念:场景和过渡。
    private void initenimate() {//这个方法设置的Activity的过渡动画，有时间好好研究一下。https://blog.csdn.net/xzy2046/article/details/41680199
        Object o = setenim(getWindow());//
        if (o == null) {
            Transition slide_left = null;//Transition 框架提供了一个方便的 API 来构建应用中不同 UI 状态切换时的动画。
//    这个框架始终围绕两个关键概念:场景和过渡。
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                slide_left = TransitionInflater.from(this).inflateTransition(android.R.transition.explode);
                getWindow().setEnterTransition(slide_left);
                Transition slide_right = TransitionInflater.from(this).inflateTransition(android.R.transition.fade);
                getWindow().setExitTransition(slide_right);
            }
        }
    }
    public Object setenim(Window window) {
        return null;
    }
    @Override
    protected void onResume() {
        //设置界面不能横屏
        if(getRequestedOrientation()!= ActivityInfo.SCREEN_ORIENTATION_PORTRAIT){
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
        super.onResume();
    }

    /**
     * 验证用户权限
     * @param grantResults
     * @return
     */
    public boolean verifyPermissions(String[] grantResults) {
        for (String result : grantResults) {
            if (ContextCompat.checkSelfPermission(this, result) != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }
    public void showMissingPermissionDialog() {
        new SystemDialogUtils().showMissingPermissionDialog(
                this,
                "提示",
                "当前应用缺少必要权限。请点击\"设置\"-\"权限\"-打开所需权限。",
                "设置",
                //点击了提示框设置的回调方法
                "取消", new SystemDialogUtils.AfterClick() {
                    @Override
                    public void confirm() {
                        startAppSettings();
                    }

                    @Override
                    public void cancle() {
                    }
                });
    }
    private void startAppSettings() {
        Log.i("test111","无权限，且用户点击了设置");

        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);//跳转到设置界面，隐式意图
        intent.setData(Uri.parse("package:" + "gcg.testproject"));//往意图里添加参数
        startActivity(intent);//跳转到目标界面
    }
}
