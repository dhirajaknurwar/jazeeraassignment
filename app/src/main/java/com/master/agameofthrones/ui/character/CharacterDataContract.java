package com.master.agameofthrones.ui.character;


import com.master.agameofthrones.model.CharacterDataModel;
import com.master.agameofthrones.ui.BasePresenter;
import com.master.agameofthrones.ui.BaseView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public interface CharacterDataContract {

    interface View extends BaseView<Presenter> {

        void showData(@NonNull List<CharacterDataModel> characterDataModelList);

        void showNoData();
    }

    interface Presenter extends BasePresenter<View> {

        void loadData(boolean forceUpdate, ArrayList<String> stringArrayList);

        void takeView(View view);

        void dropView();
    }



}
