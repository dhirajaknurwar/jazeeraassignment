package com.master.agameofthrones;


import com.master.agameofthrones.network.NetworkModule;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;


public class MyApplication extends DaggerApplication {

    public static final String TAG = MyApplication.class.getSimpleName();

    private static MyApplication _instance;



    @Override
    public void onCreate() {
        super.onCreate();
        _instance = this;

    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .application(this)
                .networkModule(new NetworkModule(BuildConfig.SERVER_URL))
                .build();
        appComponent.inject(this);
        return appComponent;
    }

    public static MyApplication getInstance() {
        return _instance;
    }
}
