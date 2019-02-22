package com.mvvm.mvvmsample.repository;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.mvvm.mvvmsample.api.ApiClient;
import com.mvvm.mvvmsample.api.PeopleResponse;
import com.mvvm.mvvmsample.api.PeopleService;
import com.mvvm.mvvmsample.model.People;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeopleRepository {
    private PeopleService apiInterface;

    public MutableLiveData<PeopleResponse> getPeople() {
        final MutableLiveData<PeopleResponse> refferAndInvitePojoMutableLiveData = new MutableLiveData<>();
        apiInterface = ApiClient.getClientAuthentication().create(PeopleService.class);
        Call<PeopleResponse> call = apiInterface.fetchPeople();
        call.enqueue(new Callback<PeopleResponse>() {

            @Override
            public void onResponse(Call<PeopleResponse> call, Response<PeopleResponse> response) {
                if(response.body()!=null)
                {
                    refferAndInvitePojoMutableLiveData.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PeopleResponse> call, Throwable t) {
                Log.e("error", t.getMessage());

            }
        });

        return refferAndInvitePojoMutableLiveData;
    }

}
