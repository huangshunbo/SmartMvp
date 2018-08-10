package com.android.minlib.smartmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.minlib.mvp.AbstractMvpActivity;
import com.android.minlib.smartmvp.contract.MainContract;
import com.android.minlib.smartmvp.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AbstractMvpActivity<MainPresenter> implements MainContract.IView {

    MainPresenter mainPresenter;
    @Override
    protected MainPresenter createPresenter() {
        mainPresenter = new MainPresenter();
        return mainPresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainPresenter.loadData();
    }

    @Override
    public void displayData(List list) {

    }

    @Override
    public void displayDataError() {

    }


}
