package com.zb.cn5appstore.mvp.view.fragment;


import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.zb.cn5appstore.base.BaseFragment;
import com.zb.cn5appstore.view.LoadingPager;

/**
 * Created by VULCAN on 2019/11/17.
 */

public class MyFragment extends BaseFragment{


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
