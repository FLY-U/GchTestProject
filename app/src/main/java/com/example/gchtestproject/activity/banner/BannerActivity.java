package com.example.gchtestproject.activity.banner;

import android.os.Bundle;

import com.example.gchtestproject.R;
import com.example.gchtestproject.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BannerActivity extends BaseActivity {
    @BindView(R.id.my_banner)
    BannerViewPager myBanner;

    private String[] imageUrls = {"http://app.biodog.cn/wlyyuploadmgr/common/2017-02-07/FF1486445677555_mid.jpg",
            "http://app.biodog.cn/wlyyuploadmgr/common/2017-02-07/MV1486445681914_mid.jpg"};
    private ArrayList<String> infos = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        //-----------------去掉标题栏--------------------------//
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //-----------------去掉标题栏--------------------------//
        ButterKnife.bind(this);
        initData();
        LunBoUtils lunBoUtils = new LunBoUtils(myBanner,BannerActivity.this,infos);
        lunBoUtils.setLunBo();

    }
    private void initData(){
        for(int i = 0;i< imageUrls.length;i++){
            infos.add(imageUrls[i]);
        }
    }
}
