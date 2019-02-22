package com.mvvm.mvvmsample.viewModel;

import android.text.TextUtils;

import com.mvvm.mvvmsample.interfaces.LoginNavigator;

import java.lang.ref.WeakReference;


public class LoginViewModel extends BaseViewModel {


    private WeakReference<LoginNavigator> mNavigator;

    public boolean isEmailAndPasswordValid(String email, String password) {
        // validate email and password
        if (TextUtils.isEmpty(email)) {
            return false;
        } else return !TextUtils.isEmpty(password);
    }


    public void login(String email, String password) {
        getNavigator().openNewActivity();


    }

    public void onServerLoginClick() {
        getNavigator().login();
    }



    private LoginNavigator getNavigator() {
        return mNavigator.get();
    }

    public void setNavigator(LoginNavigator navigator) {
        this.mNavigator = new WeakReference<>(navigator);
    }
}