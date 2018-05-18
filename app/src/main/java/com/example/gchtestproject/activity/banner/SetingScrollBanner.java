package com.example.gchtestproject.activity.banner;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class SetingScrollBanner extends ViewPager{
    public SetingScrollBanner(Context context){
        super(context);
    }
    public SetingScrollBanner(Context context, AttributeSet attrs){
        super(context,attrs);
    }
    private boolean scrollable = true;

    public void setScrollable(boolean enable){
        scrollable = enable;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        if(scrollable){
            return super.onTouchEvent(event);
        }
        return false;
    }
    @Override
    public boolean dispatchTouchEvent(MotionEvent event){
        if(scrollable){
            return super.dispatchTouchEvent(event);
        }
        return super.dispatchTouchEvent(event);
    }
    @Override
    public boolean onInterceptTouchEvent(MotionEvent event){
        if(scrollable){
            return super.onInterceptTouchEvent(event);
        }else {
            return false;
        }
    }
}
