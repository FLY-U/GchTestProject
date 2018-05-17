package com.example.gchtestproject;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.gchtestproject.base.BaseActivity;

import java.util.ArrayList;

public class MainActivity extends BaseActivity{

    private ArrayList<Fragment> fragmentArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }
    private void initFragment(){
        fragmentArray = new ArrayList<>();
//        fragmentArray.add(new  FirstFragment());

    }
}
