package com.zb.cn5appstore.base.mvpbase;

/**
 * Created by GuanJunwei on 2019/12/6.
 *
 * 该类是所有presenter接口的基类
 */

public interface BasePresenter<T extends BaseView> {

    void attachView(T view);

    void detachView();

}
