package com.master.agameofthrones.ui.character;


import com.master.agameofthrones.ActivityScoped;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class CharacterDataModule {

    @ActivityScoped
    @Binds abstract CharacterDataContract.Presenter dataPresenter(CharacterDataPresenter presenter);
}
