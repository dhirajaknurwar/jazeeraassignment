package com.master.agameofthrones;

import android.app.Application;


import com.master.agameofthrones.network.NetworkModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {NetworkModule.class,
        BooksRepositoryModule.class,
        CharacterRepositoryModule.class,
        ApplicationModule.class,
        ActivityBindingModule.class,
        AndroidSupportInjectionModule.class})

public interface AppComponent extends AndroidInjector<DaggerApplication> {

    void inject(MyApplication application);

    BooksRepository getHomeBookData();
    CharacterRepository getCharacterData();

    @Override
    void inject(DaggerApplication instance);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();

        Builder networkModule(NetworkModule networkModule);
    }
}
