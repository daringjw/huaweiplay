package com.zb.cn5appstore.fragment;


import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.zb.cn5appstore.base.BaseFragment;
import com.zb.cn5appstore.view.LoadingPager;

/**
 * Created by GuanJunwei on 2019/11/17.
 */

public class RecommendFragment extends BaseFragment {

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        show();
    }

    @Override
    protected void load() {
        //网络请求操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);
                setState(LoadingPager.LoadResult.success);
            }
        }).start();
    }

    @Override
    protected View createSuccessView() {
        TextView textView = new TextView(getContext());
        textView.setText("推荐加载成功");
        return textView;
    }


}
