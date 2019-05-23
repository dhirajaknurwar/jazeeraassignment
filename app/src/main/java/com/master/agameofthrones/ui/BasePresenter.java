package com.master.agameofthrones.ui;

public interface BasePresenter<T> {

    void takeView(T view);

    void dropView();

}
