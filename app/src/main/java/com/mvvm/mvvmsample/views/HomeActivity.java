package com.mvvm.mvvmsample.views;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.mvvm.mvvmsample.R;
import com.mvvm.mvvmsample.adapter.PeopleAdapter;
import com.mvvm.mvvmsample.api.PeopleResponse;
import com.mvvm.mvvmsample.databinding.ActivityHomeBinding;
import com.mvvm.mvvmsample.interfaces.HomeNavigator;
import com.mvvm.mvvmsample.model.People;
import com.mvvm.mvvmsample.viewModel.HomeViewModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements HomeNavigator {


    private ActivityHomeBinding activityHomeDataBinding;
    private HomeViewModel mHomeViewModel;
    private ArrayList<People> peopleList;
    private PeopleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        peopleList = new ArrayList();
        initDataBinding();
        initAdapter(activityHomeDataBinding.rvListing);
        initLiveData();

    }

    private void initLiveData() {
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        mHomeViewModel.init();
        mHomeViewModel.getPeople().observe(this, new Observer<PeopleResponse>() {
            @Override
            public void onChanged(@Nullable PeopleResponse people) {
                Log.e("response",people.toString());
                peopleList.addAll(people.getPeopleList());
                adapter.notifyDataSetChanged();
            }

        });
    }



    private void initAdapter(RecyclerView rvListing) {
         adapter = new PeopleAdapter(HomeActivity.this,peopleList);
        rvListing.setAdapter(adapter);
        rvListing.setLayoutManager(new LinearLayoutManager(this));

    }

    private void initDataBinding() {
        mHomeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);

        activityHomeDataBinding = DataBindingUtil.setContentView(HomeActivity.this, R.layout.activity_home);
        mHomeViewModel.setNavigator(this);
        activityHomeDataBinding.setViewModel(mHomeViewModel);
        activityHomeDataBinding.executePendingBindings();
        mHomeViewModel.init();

    }

    @Override
    public void onItemClick() {

    }
}
