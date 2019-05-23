package com.master.agameofthrones.ui;

public interface BaseView<T> {

    void showLoading(boolean active);

    void showError(Throwable throwable);

}
