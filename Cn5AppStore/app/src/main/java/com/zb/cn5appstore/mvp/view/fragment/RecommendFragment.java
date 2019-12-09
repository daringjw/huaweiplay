package com.zb.cn5appstore.mvp.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.zb.cn5appstore.base.BaseMvpFragment;
import com.zb.cn5appstore.mvp.presenter.impl.RecommendPresenterImpl;
import com.zb.cn5appstore.mvp.view.view.RecommendFragmentView;
import com.zb.cn5appstore.view.LoadingPager;

import javax.inject.Inject;

/**
 * Created by GuanJunwei on 2019/11/17.
 */

public class RecommendFragment extends BaseMvpFragment<RecommendPresenterImpl> implements RecommendFragmentView {

    @Inject
    public RecommendPresenterImpl mRecommendPresenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    protected void load() {

        mRecommendPresenter.getRecommendData();
        //网络请求操作
       /* new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                setState(LoadingPager.LoadResult.success);
            }
        }).start();*/


    }

    @Override
    protected View createSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText("推荐加载成功");
        return textView;
    }


    @Override
    public void onRecommendDataSuccess() {

        setState(LoadingPager.LoadResult.success);
    }

    @Override
    public void onRecommendDataError() {

        setState(LoadingPager.LoadResult.error);
    }

    @Override
    protected RecommendPresenterImpl initInjector() {

        //完成依赖注入
        mFragmentComponent.inject(this);
        //返回注入的presenter
        return mRecommendPresenter;
    }
}
