package com.master.agameofthrones;



import com.master.agameofthrones.ui.character.CharacterDataModule;
import com.master.agameofthrones.ui.character.CharactersActivity;
import com.master.agameofthrones.ui.chardetails.CharacterDetailsActivity;
import com.master.agameofthrones.ui.home.DataModule;
import com.master.agameofthrones.ui.home.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = DataModule.class)
    abstract MainActivity mainActivity();

    @ActivityScoped
    @ContributesAndroidInjector(modules = CharacterDataModule.class)
    abstract CharactersActivity charactersActivity();

    @ActivityScoped
    @ContributesAndroidInjector
    abstract CharacterDetailsActivity characterDetailsActivity();

}
