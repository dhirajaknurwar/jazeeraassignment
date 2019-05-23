package com.master.agameofthrones.ui.home;



import com.master.agameofthrones.ActivityScoped;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class DataModule {

    @ActivityScoped
    @Binds abstract DataContract.Presenter dataPresenter(DataPresenter presenter);
}
