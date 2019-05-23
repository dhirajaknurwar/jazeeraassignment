package com.master.agameofthrones;

import com.master.agameofthrones.model.BooksDataModel;

import java.util.List;

import io.reactivex.Observable;


public interface HomeBooksDataSource {

    Observable<List<BooksDataModel>> getHomeBookData();


}
