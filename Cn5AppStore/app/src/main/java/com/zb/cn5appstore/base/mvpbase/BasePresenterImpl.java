package com.zb.cn5appstore.base.mvpbase;

/**
 * Created by GuanJunwei on 2019/12/6.
 */

public class BasePresenterImpl<T extends BaseView> implements BasePresenter<T> {

    protected T mPresenterView;

    @Override
    public void attachView(T view) {

        this.mPresenterView = view;
    }

    @Override
    public void detachView() {

        this.mPresenterView = null;
    }
}
