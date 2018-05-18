package com.example.gchtestproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gchtestproject.adapter.QFragmentPagerAdapter;
import com.example.gchtestproject.base.BaseActivity;
import com.example.gchtestproject.fragment.FirstFragment;
import com.example.gchtestproject.widget.NoScrollViewPager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    @BindView(R.id.tv_title_main)
    TextView tvTitleMain;
    @BindView(R.id.activity_address)
    RelativeLayout activityAddress;
    @BindView(R.id.v_main)
    NoScrollViewPager vMain;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.ll_tab_1)
    LinearLayout llTab1;
    @BindView(R.id.ll_tab_2)
    LinearLayout llTab2;
    @BindView(R.id.ll_tab_3)
    LinearLayout llTab3;
    @BindView(R.id.imgview)
    ImageView imgview;
    @BindView(R.id.ag_msgcount)
    TextView agMsgcount;
    @BindView(R.id.tv_mg)
    TextView tvMg;
    @BindView(R.id.ll_tab_4)
    LinearLayout llTab4;
    @BindView(R.id.ll_main)
    LinearLayout llMain;
    @BindView(R.id.main_left_drawer_layout)
    RelativeLayout mainLeftDrawerLayout;
    @BindView(R.id.main_right_drawer_layout)
    RelativeLayout mainRightDrawerLayout;
    @BindView(R.id.draw)

    DrawerLayout draw;
    private ArrayList<Fragment> fragmentArray;
    private QFragmentPagerAdapter fragmentAdapter;
    private LinearLayout lastTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //-----------------去掉标题栏--------------------------//
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //-----------------去掉标题栏--------------------------//
        ButterKnife.bind(this);
        initFragment();
        initClickEvent(); //初始化点击事件
        initDraw();//设置抽屉监听事件
    }
    private void initDraw() {
        draw.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //菜单打开后，打开手势滑动操作，使可以手势滑回菜单
//                draw.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //菜单关闭后，再次关闭手势滑动操作，使不能手势滑出
//                draw.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }
    //左边菜单开关事件
    public void openLeftLayout() {
        if (draw.isDrawerOpen(mainLeftDrawerLayout)) {
            draw.closeDrawer(mainLeftDrawerLayout);
        } else {
            draw.openDrawer(mainLeftDrawerLayout);
        }
    }


    // 右边菜单开关事件
    public void openRightLayout() {
        if (draw.isDrawerOpen(mainLeftDrawerLayout)) {
            draw.closeDrawer(mainLeftDrawerLayout);
        } else {
            draw.openDrawer(mainLeftDrawerLayout);
        }
    }

    @Override
    public void onBackPressed() {
        if (draw.isDrawerOpen(GravityCompat.START)) {
            draw.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    private void initFragment() {
        fragmentArray = new ArrayList<>();
        fragmentArray.add(new FirstFragment());
        fragmentAdapter = new QFragmentPagerAdapter(getSupportFragmentManager(), fragmentArray);
        vMain.setAdapter(fragmentAdapter);


        lastTab = llTab1;
        changePage(0, llTab1); //设置默认选中第一个
        tvTitleMain.setText("第一页");
    }
    private void initClickEvent() {
        llTab1.setOnClickListener((View.OnClickListener) this);
        llTab2.setOnClickListener((View.OnClickListener)this);
        llTab3.setOnClickListener((View.OnClickListener)this);
        llTab4.setOnClickListener((View.OnClickListener)this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_tab_1:
                changePage(0, llTab1);
                tvTitleMain.setText("第一页");
                break;
            case R.id.ll_tab_2:
                changePage(1, llTab2);
                tvTitleMain.setText("第二页");
                break;
            case R.id.ll_tab_3:
                changePage(2, llTab3);
                tvTitleMain.setText("第三页");
                break;
            case R.id.ll_tab_4:
                changePage(3, llTab4);
                tvTitleMain.setText("第四页");
                break;
        }
    }

    private void changePage(int item, LinearLayout currentTab) {
        if (lastTab != null) {
            lastTab.setSelected(false);
            currentTab.setSelected(true);
            vMain.setCurrentItem(item, false);
            lastTab = currentTab;
        }

    }
}
