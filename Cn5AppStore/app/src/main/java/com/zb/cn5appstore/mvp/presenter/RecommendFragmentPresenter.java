package com.zb.cn5appstore.mvp.presenter;

import com.zb.cn5appstore.base.mvpbase.BasePresenter;
import com.zb.cn5appstore.mvp.view.view.RecommendFragmentView;

/**
 * Created by GuanJunwei on 2019/12/9.
 */

public interface RecommendFragmentPresenter extends BasePresenter<RecommendFragmentView>{

    /**
     * 获取推荐数据
     */
    void getRecommendData();

}
