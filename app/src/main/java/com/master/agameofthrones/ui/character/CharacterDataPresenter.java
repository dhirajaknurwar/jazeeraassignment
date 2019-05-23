package com.master.agameofthrones.ui.character;


import android.util.Log;

import com.master.agameofthrones.ActivityScoped;
import com.master.agameofthrones.CharacterRepository;
import com.master.agameofthrones.model.CharacterDataModel;

import java.util.ArrayList;
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
final class CharacterDataPresenter implements CharacterDataContract.Presenter {

    private final CharacterRepository mCharacterRepository;

    private List<CharacterDataModel> characterDataModelList = new ArrayList<>();

    @Nullable
    private CharacterDataContract.View mView;


    @NonNull
    private CompositeDisposable mDisposables;

    private int count = 0;
    private ArrayList<String> characterList = new ArrayList<>();

    @Inject
    CharacterDataPresenter(CharacterRepository characterRepository) {
        mCharacterRepository = characterRepository;
        mDisposables = new CompositeDisposable();
    }

    private void loadCharacterData(final boolean showLoadingUI, String url) {
        if (showLoadingUI) {
            if (mView != null) {
                mView.showLoading(true);
            }
        }

        mDisposables.clear();
        Disposable disposable = mCharacterRepository
                .getCharacterData(url)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<CharacterDataModel>() {
                    @Override
                    public void onNext(CharacterDataModel characterDataModel) {
                        characterDataModelList.add(characterDataModel);

                        if (count == (characterList.size() > 20 ? 20 : characterList.size())) {//records or more so i am taking this as 10
                            processCharacterData(characterDataModelList);
                        } else {

                            loadCharacterData(true, characterList.get(count));
                            count = count + 1;
                        }

                        Log.d("COUNT", "" + count);

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

    private void processCharacterData(List<CharacterDataModel> characterDataModelList) {

        if (characterDataModelList == null || characterDataModelList.size() == 0) {
            if (mView != null) {
                mView.showNoData();
            }
        } else {
            if (mView != null) {
                mView.showData(characterDataModelList);
            }
        }
    }


    @Override
    public void loadData(boolean forceUpdate, ArrayList<String> stringArrayList) {
        // count=stringArrayList.size();
        if (stringArrayList != null) {
            count = count + 1;
            characterList.addAll(stringArrayList);
            loadCharacterData(true, characterList.get(0));
            boolean mFirstLoad = false;
        }
    }

    @Override
    public void takeView(CharacterDataContract.View view) {

        mView = view;
        this.loadData(false,
                characterList);
    }

    @Override
    public void dropView() {
        mView = null;
        mDisposables.clear();
    }
}
