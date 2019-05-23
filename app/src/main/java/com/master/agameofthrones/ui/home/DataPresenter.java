package com.master.agameofthrones.ui.home;


import com.master.agameofthrones.ActivityScoped;
import com.master.agameofthrones.BooksRepository;
import com.master.agameofthrones.model.BooksDataModel;

import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Inject;

import androidx.annotation.NonNull;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

@ActivityScoped
final class DataPresenter implements DataContract.Presenter {

    private final BooksRepository mBooksRepository;

    @Nullable
    private DataContract.View mView;


    @NonNull
    private CompositeDisposable mDisposables;

    @Inject
    DataPresenter(BooksRepository booksRepository) {
        mBooksRepository = booksRepository;
        mDisposables = new CompositeDisposable();
    }

    private void loadHomeBooksData(final boolean showLoadingUI) {
        if (showLoadingUI) {
            if (mView != null) {
                mView.showLoading(true);
            }
        }

        mDisposables.clear();
        Disposable disposable = mBooksRepository
                .getHomeBookData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<BooksDataModel>>() {
                    @Override
                    public void onNext(List<BooksDataModel> booksDataModelList) {
                        processHomeBooksData(booksDataModelList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (mView != null) {
                            mView.showLoading(false);
                            mView.showError(e);
                        }

                    }

                    @Override
                    public void onComplete() {
                        if (mView != null) {
                            mView.showLoading(false);
                        }
                    }
                });

        mDisposables.add(disposable);
    }

    private void processHomeBooksData(List<BooksDataModel> booksDataModelList) {

        if (booksDataModelList == null || booksDataModelList.size() == 0) {
            if (mView != null) {
                mView.showNoData();
            }
        } else {
            if (mView != null) {
                mView.showData(booksDataModelList);
            }
        }
    }



    @Override
    public void loadData(boolean forceUpdate) {
        loadHomeBooksData(true);
        boolean mFirstLoad = false;
    }

    @Override
    public void takeView(DataContract.View view) {
        mView = view;
        this.loadData(false);
    }

    @Override
    public void dropView() {
        mView = null;
        mDisposables.clear();
    }
}
