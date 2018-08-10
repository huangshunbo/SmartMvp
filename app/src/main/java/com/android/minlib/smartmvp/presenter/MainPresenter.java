package com.android.minlib.smartmvp.presenter;

import com.android.minlib.mvp.BasePresenter;
import com.android.minlib.smartmvp.contract.MainContract;
import com.android.minlib.smartmvp.repository.MainRepository;

import java.util.List;

public class MainPresenter extends BasePresenter<MainContract.IView> implements MainContract.IPresenter{

    MainRepository repository = new MainRepository();

    @Override
    public void loadData() {
            List list = repository.loadData();
            if(isViewAttached()){
                getView().displayData(list);
                getView().displayDataError();
            }
    }
}
