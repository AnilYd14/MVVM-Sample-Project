package com.mvvm.mvvmsample;

import android.app.Activity;
import android.app.Application;

import dagger.android.AndroidInjector;
import dagger.android.HasActivityInjector;

public class MvvmApplication extends Application implements HasActivityInjector {

    @Override
    public void onCreate() {
        super.onCreate();
    /*    DaggerAppComponent.builder()
                .application(this)
                .build()
                .inject(this);*/
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return null;
    }
}
