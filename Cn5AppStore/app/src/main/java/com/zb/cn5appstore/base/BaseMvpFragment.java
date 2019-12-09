package com.zb.cn5appstore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.zb.cn5appstore.base.mvpbase.BasePresenter;
import com.zb.cn5appstore.base.mvpbase.BaseView;
import com.zb.cn5appstore.di.component.DaggerFragmentComponent;
import com.zb.cn5appstore.di.component.FragmentComponent;
import com.zb.cn5appstore.di.module.FragmentModule;

/**
 * Created by GuanJunwei on 2019/12/9.
 */

public abstract class BaseMvpFragment<T extends BasePresenter> extends BaseFragment implements BaseView {

    protected FragmentComponent mFragmentComponent;
    protected T mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initFragmentComponent();
        mPresenter = initInjector();
        mPresenter.attachView(this);


    }

    private void initFragmentComponent() {
        mFragmentComponent = DaggerFragmentComponent.builder()
                .fragmentModule(new FragmentModule(this))
                .appComponent(((StoreApplication) getActivity().getApplication()).getAppComponent())
                .build();


    }

    //完成依赖注入并返回注入的Presenter
    protected abstract T initInjector();

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void showToast(String msg) {

        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();

    }

}
