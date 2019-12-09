package com.zb.cn5appstore.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.zb.cn5appstore.base.mvpbase.BasePresenter;
import com.zb.cn5appstore.base.mvpbase.BaseView;
import com.zb.cn5appstore.di.component.ActivityComponent;
import com.zb.cn5appstore.di.component.DaggerActivityComponent;
import com.zb.cn5appstore.di.module.ActivityModule;

/**
 * Created by GuanJunwei on 2019/12/6.
 *
 * activity实现mvp的基类
 *
 *
 */

public abstract class BaseMvpActivity<T extends BasePresenter> extends BaseActivity implements BaseView {

    protected ActivityComponent mActivityComponent;
    protected T mPresenter;

    //
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initActivityComponent();
        mPresenter = initInjector();
        //绑定view
        mPresenter.attachView(this);

    }

    public void initActivityComponent() {

        mActivityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .appComponent(((StoreApplication) getApplication()).getAppComponent())
                .build();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (mPresenter!=null){
            //解除绑定
            mPresenter.detachView();
        }
    }

    @Override
    public void showToast(String msg) {

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 完成注入并返回
     * @return
     */
    protected  abstract  T  initInjector();


}
