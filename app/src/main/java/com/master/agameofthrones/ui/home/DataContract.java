package com.master.agameofthrones.ui.home;


import com.master.agameofthrones.model.BooksDataModel;
import com.master.agameofthrones.ui.BasePresenter;
import com.master.agameofthrones.ui.BaseView;

import java.util.List;

import androidx.annotation.NonNull;

public interface DataContract {

    interface View extends BaseView<Presenter> {

        void showData(@NonNull List<BooksDataModel> homeBooksDataModel);

        void showNoData();
    }

    interface Presenter extends BasePresenter<View> {

        void loadData(boolean forceUpdate);

        void takeView(View view);

        void dropView();
    }



}
