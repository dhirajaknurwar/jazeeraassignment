package com.master.agameofthrones;

import com.master.agameofthrones.model.CharacterDataModel;

import io.reactivex.Observable;


public interface CharacterDataSource {

    Observable<CharacterDataModel> getCharacterData(String url);


}
