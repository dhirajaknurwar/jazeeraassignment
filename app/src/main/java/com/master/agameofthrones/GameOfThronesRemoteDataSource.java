package com.master.agameofthrones;


import com.master.agameofthrones.core.ApiService;
import com.master.agameofthrones.model.BooksDataModel;
import com.master.agameofthrones.model.CharacterDataModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class GameOfThronesRemoteDataSource implements HomeBooksDataSource ,CharacterDataSource{

    private ApiService mApiService;

    @Inject
    public GameOfThronesRemoteDataSource(ApiService apiService) {
        mApiService = apiService;
    }


    @Override
    public Observable<List<BooksDataModel>> getHomeBookData() {
        return mApiService.getHomeBooksDataApiCall();
    }

    @Override
    public Observable<CharacterDataModel> getCharacterData(String url) {
        return mApiService.getCharacterDataApiCall(url);
    }
}
