package com.example.gchtestproject.activity.selectphoto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.example.gchtestproject.R;
import com.example.gchtestproject.base.BaseActivity;

import org.xutils.common.util.LogUtil;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaTuActivity extends BaseActivity implements View.OnClickListener/*实现View 的OnClickListener方法，方便实现按钮点击事件*/ {

    @BindView(R.id.head_title)//@BindView()
    TextView headTitle;
    @BindView(R.id.fanhui)
    LinearLayout fanhui;
    @BindView(R.id.tuikuan)
    LinearLayout tuikuan;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.ib_more)
    ImageButton ibMore;
    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.v_pic)
    ViewPager vPic;
    private ArrayList<String> JieGuoUrlsss = new ArrayList<>();
    private ArrayList<String> JieGuoUrlsss2 = new ArrayList<>();
    public MyFragmentPagerAdapter pagerAdapter;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_da_tu);
        ButterKnife.bind(this);
        initView();
    }
    private void initView(){
        ibMore.setOnClickListener(this);
        fanhui.setOnClickListener(this);

        Intent intent = getIntent();
        JieGuoUrlsss = intent.getStringArrayListExtra("JieGuoUrlsss");
        position = intent.getIntExtra("position",0);
        LogUtil.i("传递过来的:"+JieGuoUrlsss.size());
        String fromWhere = intent.getStringExtra("fromWhere");
        if(!TextUtils.isEmpty(fromWhere)&& fromWhere.equals("datu")){
            ibMore.setVisibility(View.VISIBLE);
        }
        if(JieGuoUrlsss!=null&&JieGuoUrlsss.size()>0){
            for(int i=0;i<JieGuoUrlsss.size();i++){
                String s = JieGuoUrlsss.get(i);
                String a = s.replace("_mid","");
                JieGuoUrlsss2.add(a);
            }
        }
        JieGuoUrlsss.clear();
        JieGuoUrlsss.addAll(JieGuoUrlsss2);
        LogUtils.i("换成大图后的:"+JieGuoUrlsss.size());
    }
}
