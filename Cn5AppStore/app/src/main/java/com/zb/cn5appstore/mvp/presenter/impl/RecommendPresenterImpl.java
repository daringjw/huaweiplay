package com.zb.cn5appstore.mvp.presenter.impl;

import android.os.SystemClock;

import com.zb.cn5appstore.base.mvpbase.BasePresenterImpl;
import com.zb.cn5appstore.mvp.presenter.RecommendFragmentPresenter;
import com.zb.cn5appstore.mvp.view.view.RecommendFragmentView;

import javax.inject.Inject;

/**
 * Created by GuanJunwei on 2019/12/9.
 */

public class RecommendPresenterImpl extends BasePresenterImpl<RecommendFragmentView> implements RecommendFragmentPresenter {

    @Inject
    public RecommendPresenterImpl(){

    }

    @Override
    public void getRecommendData() {

        //模拟网络请求
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                mPresenterView.onRecommendDataSuccess();
            }
        }).start();

    }

}
