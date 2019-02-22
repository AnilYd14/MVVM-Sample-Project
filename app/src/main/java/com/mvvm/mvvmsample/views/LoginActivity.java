package com.mvvm.mvvmsample.views;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import com.mvvm.mvvmsample.R;
import com.mvvm.mvvmsample.databinding.ActivityMainBinding;
import com.mvvm.mvvmsample.interfaces.LoginNavigator;
import com.mvvm.mvvmsample.viewModel.LoginViewModel;

public class LoginActivity extends AppCompatActivity implements LoginNavigator {


    private ActivityMainBinding activityMainBinding;
    private LoginViewModel mLoginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mLoginViewModel = new LoginViewModel();
        mLoginViewModel.setNavigator(this);
        activityMainBinding.setViewModel(mLoginViewModel);
        activityMainBinding.executePendingBindings();

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

