package com.android.minlib.mvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
public abstract class AbstractMvpActivity<T extends BasePresenter>
        extends AppCompatActivity implements IMvpView {
    protected T mCurrentPresenter;

    /**
     *<br> Description: 创建Presenters
     *<br> Author:      liaoshengjian
     *<br> Date:        2017/5/24 17:10
     *
     * @return List presenterList
     */
    protected abstract T createPresenter();

    public T getCurrentPresenter() {
        return mCurrentPresenter;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentPresenter = createPresenter();
        if (mCurrentPresenter != null) {
            mCurrentPresenter.attachView(this);
        }
    }

    @Override
    public void onFinish() {
        if (!isFinishing()) {
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mCurrentPresenter != null) {
            mCurrentPresenter.detachView();
        }
    }
}