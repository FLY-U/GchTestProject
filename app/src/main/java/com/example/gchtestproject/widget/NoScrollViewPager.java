package com.example.gchtestproject.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class NoScrollViewPager extends ViewPager{
    private boolean noScroll =true;
    public NoScrollViewPager(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    public NoScrollViewPager(Context context){
        super(context);
    }
    public void NoScrollViewPager(boolean noScroll){
        this.noScroll = noScroll;
    }
    @Override
    public void scrollTo(int x,int y){
        super.scrollTo(x,y);
    }
    @Override
    public boolean onTouchEvent(MotionEvent arg0){
        if(noScroll){
            return false;
        }
        return super.onTouchEvent(arg0);
    }
    @Override
    public void setCurrentItem(int item,boolean smoothScroll){
        super.setCurrentItem(item,smoothScroll);
    }
    @Override
    public void setCurrentItem(int item){
        super.setCurrentItem(item);
    }
}
