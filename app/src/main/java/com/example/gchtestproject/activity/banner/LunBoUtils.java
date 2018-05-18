package com.example.gchtestproject.activity.banner;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class LunBoUtils {
    private BannerViewPager cycleViewPager;
    private List<ImageView> views = new ArrayList<>();
    private Context context;
    private ArrayList<String> infos;

    public LunBoUtils(BannerViewPager cycleViewPager,Context context,ArrayList<String> infos){
        this.cycleViewPager = cycleViewPager;
        this.context = context;
        this.infos = infos;
    }
    public void setLunBo(){
        initData();
        setData();
        setViewPagerAndIndicator();
    }
    private void setViewPagerAndIndicator(){
        cycleViewPager.setWheel(true);
        cycleViewPager.setScrollTime(2000);
        cycleViewPager.setIndicatorCenter();
    }
    private void setData(){
        views.add(ViewFactory.getImageView(context,infos.get(0)));
        cycleViewPager.setData(views,infos,new BannerViewPager.OnItemClickListener(){
            @Override
            public void onItemClick(int position){
                Toast.makeText((Activity)context,position+"",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initData(){
        views.add(ViewFactory.getImageView(context,infos.get(infos.size() - 1)));
        for (int i=0;i<infos.size();i++){
            views.add(ViewFactory.getImageView(context,infos.get(i)));
        }
    }
}
