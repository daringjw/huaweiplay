package com.zb.cn5appstore.di.component;

import android.app.Activity;
import android.content.Context;

import com.zb.cn5appstore.mvp.view.activity.HomeActivity;
import com.zb.cn5appstore.di.module.ActivityModule;
import com.zb.cn5appstore.di.scope.ContextLife;
import com.zb.cn5appstore.di.scope.PerActivity;

import dagger.Component;

/**
 * Created by GuanJunwei on 2019/11/30.
 */
@PerActivity
@Component(modules = ActivityModule.class ,dependencies = AppComponent.class)
public interface ActivityComponent {

    @ContextLife("Activity")
    Context getActivityContext();

    @ContextLife("Application")
    Context getApplicationContext();

    Activity getActivity();

    void inject(HomeActivity activity);
}
