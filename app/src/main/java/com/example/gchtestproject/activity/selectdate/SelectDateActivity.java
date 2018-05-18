package com.example.gchtestproject.activity.selectdate;

import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.gchtestproject.R;
import com.example.gchtestproject.base.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SelectDateActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView tvEndTime;
    private Calendar c;
    @RequiresApi(api = Build.VERSION_CODES.N)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_date);
        //-----------------去掉标题栏--------------------------//
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }
        //-----------------去掉标题栏--------------------------//
        ButterKnife.bind(this);
        initClickEvent();
        c = Calendar.getInstance();
    }
    private void initClickEvent(){
        tvStartTime.setOnClickListener(this);
        tvEndTime.setOnClickListener(this);
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_start_time:
                showDateDialog();
                break;
            case R.id.tv_end_time:
                showDateDialog();
            break;
        }
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDateDialog() {
        new DoubleDatePickerDialog(SelectDateActivity.this, 0, new DoubleDatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker startDatePicker,
                                  int startYear, int startMonthOfYear, int startDayOfMonth,
                                  DatePicker endDatePicker,
                                  int endYear, int endMonthOfYear, int endDayOfMonth) {

                tvStartTime.setText(startYear+"-"+(startMonthOfYear + 1)+"-"+startDayOfMonth);
                tvEndTime.setText(endYear+"-"+(endMonthOfYear + 1)+"-"+endDayOfMonth);
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), true).show(); //最后一个参数传true，表示可以显示日
    }
}
