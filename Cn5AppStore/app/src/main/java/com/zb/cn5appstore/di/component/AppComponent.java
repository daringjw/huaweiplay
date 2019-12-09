package com.zb.cn5appstore.di.component;

import android.content.Context;

import com.zb.cn5appstore.di.module.ApplicationModule;
import com.zb.cn5appstore.di.scope.ContextLife;
import com.zb.cn5appstore.di.scope.PerApp;

import dagger.Component;

/**
 * Created by GuanJunwei on 2019/11/30.
 * 提供全局单例的Context对象
 */
@PerApp
@Component(modules = ApplicationModule.class)
public interface AppComponent {
    @ContextLife("Application")
    Context getApplicationContext();



}
