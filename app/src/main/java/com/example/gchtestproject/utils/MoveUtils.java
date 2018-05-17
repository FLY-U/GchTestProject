package com.example.gchtestproject.utils;

import android.content.Context;
import android.content.Intent;

public class MoveUtils {
    public static void go(Context context,Class clazz){
        context.startActivity(new Intent(context,clazz));
    }
}
