package com.mvvm.mvvmsample.viewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.mvvm.mvvmsample.api.PeopleResponse;
import com.mvvm.mvvmsample.model.People;
import com.mvvm.mvvmsample.repository.PeopleRepository;
import com.mvvm.mvvmsample.views.HomeActivity;

public class HomeViewModel extends ViewModel {

    public void setNavigator(HomeActivity homeActivity) {

    }


    private MutableLiveData<PeopleResponse> data;
    private PeopleRepository peopleRepository;

    public HomeViewModel() {
        peopleRepository = new PeopleRepository();
    }

    public void init() {
        if (this.data != null) {
            // ViewModel is created per Fragment so
            // we know the userId won't change
            return;
        }
        data = peopleRepository.getPeople();
    }

    public MutableLiveData<PeopleResponse> getPeople() {
        return this.data;
    }
}
