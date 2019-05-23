package com.master.agameofthrones;

import com.master.agameofthrones.model.BooksDataModel;
import com.master.agameofthrones.remote.Remote;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

@Singleton
public class BooksRepository implements HomeBooksDataSource {

    private final HomeBooksDataSource mHomeBooksDataSource;

    @Inject
    BooksRepository(@Remote HomeBooksDataSource homeBooksDataSource) {
        mHomeBooksDataSource = checkNotNull(homeBooksDataSource);
    }

    @Override
    public Observable<List<BooksDataModel>> getHomeBookData() {
        return mHomeBooksDataSource.getHomeBookData();
    }
}
