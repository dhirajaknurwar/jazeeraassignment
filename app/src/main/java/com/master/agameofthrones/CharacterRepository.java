package com.master.agameofthrones;

import com.master.agameofthrones.model.CharacterDataModel;
import com.master.agameofthrones.remote.Remote;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

import static com.google.common.base.Preconditions.checkNotNull;

@Singleton
public class CharacterRepository implements CharacterDataSource {

    private final CharacterDataSource mCharacterDataSource;

    @Inject
    CharacterRepository(@Remote CharacterDataSource characterDataSource) {
        mCharacterDataSource = checkNotNull(characterDataSource);
    }


    @Override
    public Observable<CharacterDataModel> getCharacterData(String url) {
        return mCharacterDataSource.getCharacterData(url);
    }
}
