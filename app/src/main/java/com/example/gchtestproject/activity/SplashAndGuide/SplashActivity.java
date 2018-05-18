package com.example.gchtestproject.activity.SplashAndGuide;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gchtestproject.MainActivity;
import com.example.gchtestproject.R;
import com.example.gchtestproject.base.BaseActivity;
import com.example.gchtestproject.common.Word;

import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;


public class SplashActivity extends BaseActivity implements View.OnClickListener {
    @BindView(R.id.iv_splash)
    ImageView ivSplash;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.activity_spalh)
    RelativeLayout activitySpalh;

    private TimeCount timeCount = new TimeCount(4000, 1000);

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalh);
        //-----------------去掉标题栏--------------------------//
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //-----------------去掉标题栏--------------------------//
        ButterKnife.bind(this);
        tvTime.setOnClickListener(this);
        timeCount.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_time:
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                timeCount.cancel();
                finish();
                break;
        }
    }

    class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            String s = millisUntilFinished / 1000 + "";
            tvTime.setText("跳过" + s);
        }

        @Override
        public void onFinish() {
            goWhere();
        }
    }

    @Override
    public void onBackPressed() {

    }

    private void goWhere() {
        boolean aBoolean = spUtils.getBoolean(Word.FIRST_LAUNCH); //如果不存在，则返回默认值：false
        if (aBoolean == false) {
            spUtils.put(Word.FIRST_LAUNCH, true); //当用户第一次打开时，设置为true
            Intent intent = new Intent(SplashActivity.this, GuideActivity.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
        }
        finish();
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
