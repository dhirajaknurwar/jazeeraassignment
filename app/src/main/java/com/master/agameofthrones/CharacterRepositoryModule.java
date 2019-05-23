package com.master.agameofthrones;


import com.master.agameofthrones.core.ApiService;
import com.master.agameofthrones.remote.Remote;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class CharacterRepositoryModule {


    @Provides
    @Singleton
    @Remote
    CharacterDataSource provideCareRemoteDataSource(ApiService apiService) {
        return new GameOfThronesRemoteDataSource(apiService);
    }
}
