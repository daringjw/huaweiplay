package com.zb.cn5appstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.zb.cn5appstore.di.module.FragmentModule;
import com.zb.cn5appstore.di.scope.ContextLife;
import com.zb.cn5appstore.di.scope.PerFragment;
import com.zb.cn5appstore.mvp.view.fragment.CategoryFragment;
import com.zb.cn5appstore.mvp.view.fragment.RecommendFragment;
import com.zb.cn5appstore.mvp.view.fragment.TopFragment;

import dagger.Component;

/**
 * Created by GuanJunwei on 2019/11/30.
 */
@PerFragment
@Component(modules = FragmentModule.class,dependencies = AppComponent.class)
public interface FragmentComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(RecommendFragment fragment) ;
    void inject(CategoryFragment fragment);
    void inject(TopFragment fragment);


}
