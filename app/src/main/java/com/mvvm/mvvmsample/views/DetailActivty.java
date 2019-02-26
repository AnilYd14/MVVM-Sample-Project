package com.mvvm.mvvmsample.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mvvm.mvvmsample.BR;
import com.mvvm.mvvmsample.BaseActivity;
import com.mvvm.mvvmsample.R;
import com.mvvm.mvvmsample.databinding.ActivityDetailActivtyBinding;
import com.mvvm.mvvmsample.viewModel.DetailViewModel;

public class DetailActivty extends BaseActivity<ActivityDetailActivtyBinding, DetailViewModel> {

    private DetailViewModel mDetailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detail_activty;
    }

    @Override
    public DetailViewModel getViewModel() {
        mDetailViewModel = new DetailViewModel();
        return mDetailViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }
}
