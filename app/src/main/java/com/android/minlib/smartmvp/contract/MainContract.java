package com.android.minlib.smartmvp.contract;

import com.android.minlib.mvp.IMvpView;

import java.util.List;

public interface MainContract {
    interface IView extends IMvpView
    {
        void displayData(List list);
        void displayDataError();
    }
    interface IPresenter
    {
        void loadData();
    }
}
