package com.mvvm.mvvmsample.views;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.mvvm.mvvmsample.BR;
import com.mvvm.mvvmsample.BaseActivity;
import com.mvvm.mvvmsample.R;
import com.mvvm.mvvmsample.databinding.ActivityMainBinding;
import com.mvvm.mvvmsample.interfaces.LoginNavigator;
import com.mvvm.mvvmsample.viewModel.LoginViewModel;

import javax.inject.Inject;

public class LoginActivity extends BaseActivity<ActivityMainBinding, LoginViewModel> implements LoginNavigator {


    private ActivityMainBinding activityMainBinding;
    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginViewModel.setNavigator(this);
        activityMainBinding = getViewDataBinding();

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public LoginViewModel getViewModel() {
        mLoginViewModel = new LoginViewModel();
        return mLoginViewModel;
    }

    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public void login() {
        String email = activityMainBinding.inEmail.getText().toString();
        String password = activityMainBinding.inPassword.getText().toString();
        if (mLoginViewModel.isEmailAndPasswordValid(email, password)) {
            mLoginViewModel.login(email, password);
        } else {
            Toast.makeText(this, "email or password is invalid", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void openNewActivity() {
       Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
       startActivity(intent);
    }
}

