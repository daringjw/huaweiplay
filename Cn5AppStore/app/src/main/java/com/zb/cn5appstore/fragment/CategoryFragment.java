package com.zb.cn5appstore.fragment;


import android.os.SystemClock;
import android.view.View;
import android.widget.TextView;

import com.zb.cn5appstore.base.BaseFragment;

/**
 * Created by VULCAN on 2019/11/17.
 */

public class CategoryFragment extends BaseFragment{


    @Override
    protected void load() {
        //网络请求操作
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(2000);

                setState(LoadResult.error);
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
