package com.zb.cn5appstore.di.module;

import android.app.Activity;
import android.content.Context;

import com.zb.cn5appstore.di.scope.ContextLife;
import com.zb.cn5appstore.di.scope.PerActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by GuanJunwei on 2019/11/30.
 */
@Module
public class ActivityModule {
    private Activity mActivity;
    public ActivityModule (Activity activity){
        this.mActivity =activity;
    }

    @Provides
    @PerActivity
    public Activity provideActivity(){
        return mActivity;
    }

    @Provides
    @PerActivity
    @ContextLife("Activity")
    public Context provideActivityContext(){
        return mActivity;
    }
}
