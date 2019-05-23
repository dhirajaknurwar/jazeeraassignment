package com.master.agameofthrones.core;

import com.master.agameofthrones.model.BooksDataModel;
import com.master.agameofthrones.model.CharacterDataModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {

    @GET(APIConstants.GET_BOOKS_LIST)
    Observable<List<BooksDataModel>> getHomeBooksDataApiCall();

    @GET()
    Observable<CharacterDataModel> getCharacterDataApiCall(@Url String url);
}
