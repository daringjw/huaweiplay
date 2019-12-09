package com.zb.cn5appstore.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zb.cn5appstore.view.LoadingPager;

/**
 * created by GuanJunwei
 */
public abstract class BaseFragment extends Fragment {

    private LoadingPager loadingPager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (loadingPager == null) {
            loadingPager = new LoadingPager(getContext()) {

                @Override
                public View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }

                @Override
                public void load() {

                    BaseFragment.this.load();
                }
            };

        }

        return loadingPager;

    }

    public void show() {
        if (loadingPager != null) {
            loadingPager.show();
        }

    }

    public void setState(LoadingPager.LoadResult result) {

        if (loadingPager != null) {
            loadingPager.setState(result);
        }
    }


    /**
     * 请求网络，修改状态
     */
    protected abstract void load();


    protected abstract View createSuccessView();


}
