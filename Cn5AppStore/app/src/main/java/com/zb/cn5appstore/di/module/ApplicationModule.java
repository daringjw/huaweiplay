package com.zb.cn5appstore.di.module;

import android.content.Context;

import com.zb.cn5appstore.base.StoreApplication;
import com.zb.cn5appstore.di.scope.ContextLife;
import com.zb.cn5appstore.di.scope.PerApp;

import dagger.Module;
import dagger.Provides;

/**
 * Created by GuanJunwei on 2019/11/30.
 */

@Module
public class ApplicationModule {

    private StoreApplication mApplication ;

    public ApplicationModule(StoreApplication application){
        this.mApplication = application ;
    }

    @Provides
    @PerApp
    @ContextLife("Application")
    public Context provideApplicationContext(){
        return mApplication.getApplicationContext() ;
    }

}
