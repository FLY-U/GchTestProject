package com.example.gchtestproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gchtestproject.R;
import com.example.gchtestproject.utils.MoveUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class FirstFragment extends BaseFragment implements View.OnClickListener {
    @BindView(R.id.tv_select_photo)
    TextView tv_select_photo;
    @BindView(R.id.tv_select_video)
    TextView tvSelectVideo;
    @BindView(R.id.tv_banner)
    TextView tvBanner;
    @BindView(R.id.tv_date)
    TextView tvDate;
    @BindView(R.id.tv_date2)
    TextView tvDate2;
    @BindView(R.id.tv_contect)
    TextView tvContect;
    @BindView(R.id.tv_progress_dialog)
    TextView tvProgressDialog;
    @BindView(R.id.tv_select_dialog)
    TextView tvSelectDialog;
    @BindView(R.id.tv_popwindow)
    TextView tvPopwindow;
    @BindView(R.id.tv_round_progressbar)
    TextView tvRoundProgressbar;
    @BindView(R.id.tv_ratingbar)
    TextView tvRatingbar;
    @BindView(R.id.tv_update)
    TextView tvUpdate;
    @BindView(R.id.tv_sanji)
    TextView tvSanji;
    @BindView(R.id.tv_erweima)
    TextView tvErweima;
    @BindView(R.id.tv_pay)
    TextView tv_pay;
    @BindView(R.id.tv_refresh_loadmore)
    TextView tv_refresh_loadmore;
    @BindView(R.id.tv_listview_delete)
    TextView tv_listview_delete;
    @BindView(R.id.tv_listview_delete2)
    TextView tv_listview_delete2;
    @BindView(R.id.tv_list_count_down)
    TextView tv_list_count_down;
    @BindView(R.id.tv_relogin_dialog)
    TextView tv_relogin_dialog;
    @BindView(R.id.tv_location)
    TextView tv_location;

    public FirstFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        initClickEvent();
        return view;
    }

    private void initClickEvent() {
        tv_select_photo.setOnClickListener(this);
        tvSelectVideo.setOnClickListener(this);
        tvBanner.setOnClickListener(this);
        tvDate.setOnClickListener(this);
        tvDate2.setOnClickListener(this);
        tvContect.setOnClickListener(this);
        tvProgressDialog.setOnClickListener(this);
        tvSelectDialog.setOnClickListener(this);
        tvPopwindow.setOnClickListener(this);
        tvRoundProgressbar.setOnClickListener(this);
        tvRatingbar.setOnClickListener(this);
        tvUpdate.setOnClickListener(this);
        tvSanji.setOnClickListener(this);
        tvErweima.setOnClickListener(this);
        tv_pay.setOnClickListener(this);
        tv_refresh_loadmore.setOnClickListener(this);
        tv_listview_delete.setOnClickListener(this);
        tv_listview_delete2.setOnClickListener(this);
        tv_list_count_down.setOnClickListener(this);
        tv_relogin_dialog.setOnClickListener(this);
        tv_location.setOnClickListener(this);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.tv_select_photo:
                MoveUtils.go(getActivity(),SelectPhotoActivity.class);
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
