package com.zb.cn5appstore.base;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.zb.cn5appstore.R;
import com.zb.cn5appstore.utils.UIUtils;

/**
 * created by GuanJunwei
 */
public abstract class BaseFragment extends Fragment {

    /**
     * 默认状态
     */
    public final static int STATE_UNKNOWN = 0;
    /**
     * 加载中状态
     */
    public final static int STATE_LOADING = 1;
    /**
     * 加载失败状态
     */
    public final static int STATE_ERROR = 2;
    /**
     * 加载成功状态
     */
    public final static int STATE_SUCCESS = 3;
    /**
     * 加载为空状态
     */
    public final static int STATE_EMPTY = 4;

    private int state = STATE_UNKNOWN;

    private View loadingView;
    private View errorView;
    private View emptyView;
    private View successView;

    private FrameLayout frameLayout;


    //界面如何显示？可以将这四种布局添加在帧布局中，根据不同状态显示不同界面

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (frameLayout == null) {
            frameLayout = new FrameLayout(getContext());
            init();

        }

        return frameLayout;

    }

    public void show() {

        if (state == STATE_UNKNOWN || state == STATE_ERROR || state == STATE_EMPTY) {

            state = STATE_LOADING;
            load();
        }

        showPager();

    }

    /**
     * 请求网络，修改状态
     */
    protected abstract void load();

    /**
     * 设置状态
     *
     * @param result
     */
    protected void setState(LoadResult result) {

        state = result.getValue();

        UIUtils.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showPager();
            }
        });


    }

    /**
     * 请求结果的枚举
     */
    public enum LoadResult {
        error(STATE_ERROR), success(STATE_SUCCESS), empty(STATE_EMPTY);
        int value;

        LoadResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }


    /**
     * 将布局添加到帧布局中
     */
    private void init() {

        if (loadingView == null) {
            loadingView = createLoadingView();
            frameLayout.addView(loadingView, new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));

        }


        if (errorView == null) {
            errorView = createErrorView();
            frameLayout.addView(errorView, new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));
        }

        if (emptyView == null) {
            emptyView = createEmptyViewView();
            frameLayout.addView(emptyView, new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));
        }

        showPager();


    }

    private View createEmptyViewView() {

        return UIUtils.inflate(R.layout.loading_page_empty);
    }

    /**
     * 根据不同的状态显示不同的布局
     */
    private void showPager() {

        if (loadingView != null) {
            loadingView.setVisibility(state == STATE_UNKNOWN || state == STATE_LOADING ? View.VISIBLE : View.GONE);
        }

        if (errorView != null) {
            errorView.setVisibility(state == STATE_ERROR ? View.VISIBLE : View.GONE);
        }

        if (emptyView != null) {
            emptyView.setVisibility(state == STATE_EMPTY ? View.VISIBLE : View.GONE);
        }

        if (state == STATE_SUCCESS && successView == null) {
            successView = createSuccessView();
            frameLayout.addView(successView, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));
        }

    }

    protected abstract View createSuccessView();

    private View createErrorView() {

        return UIUtils.inflate(R.layout.loading_error_page);
    }

    private View createLoadingView() {

        return UIUtils.inflate(R.layout.loading_page);

    }

}
