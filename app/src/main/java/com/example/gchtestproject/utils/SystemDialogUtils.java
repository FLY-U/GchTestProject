package com.example.gchtestproject.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class SystemDialogUtils {
    private AfterClick afterClick;
    public void showMissingPermissionDialog(Context context, String title, String message, String confirm, String cancle, final AfterClick afterClick) {
        this.afterClick = afterClick;

        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(title);
        builder.setMessage(message);

        // 拒绝, 退出应用或关闭当前界面
        builder.setNegativeButton(cancle,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        afterClick.cancle();
                    }
                });

        builder.setPositiveButton(confirm,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        afterClick.confirm();
                    }
                });

        builder.setCancelable(false);
        builder.show();
    }
    public interface AfterClick{
        void confirm();
        void cancle();
    }
}
