package com.example.gchtestproject.activity.banner;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.gchtestproject.R;

public class ViewFactory {
    public static ImageView getImageView(Context context, String url) {
        ImageView imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.item_view_banner, null);
        Glide.with(context).load(url).into(imageView);
        return imageView;
    }
}
