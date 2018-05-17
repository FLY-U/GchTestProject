package com.example.gchtestproject.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.example.gchtestproject.common.MyApp;
import com.example.gchtestproject.dialog.ProgressDialog;

public class BaseFragment extends Fragment {
    public Context mContext;
    public MyApp myApp;
    public ProgressDialog progressDialog;

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        mContext = context;
        myApp = MyApp.getInstance();
    }
    public void dialogShow(String message){
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMsg(message);
        progressDialog.setCancelable(false);
        progressDialog.show();
    }
    public void dialogShow(){
        dialogShow("加载中...");
    }
    public void dialogDismiss(){
        progressDialog.dismiss();
    }
    public void dialogComplete(ProgressDialog.OnCompleteListener listener,String comlMessage){
        progressDialog.complete(listener,comlMessage);
    }
}
