package com.zb.cn5appstore.base;

import android.os.Handler;

import com.zb.cn5appstore.App;
import com.zb.cn5appstore.di.component.AppComponent;
import com.zb.cn5appstore.di.component.DaggerAppComponent;
import com.zb.cn5appstore.di.module.ApplicationModule;


/**
 * <p>Description:
 *
 * @author xzhang
 */

public class StoreApplication extends App {

    private static int mMainThreadId;
    private static Handler mHandler;
    private AppComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();

        mHandler = new Handler();
        initApplicationComponent();


    }

    private void initApplicationComponent(){

        mAppComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this)).build();

    }

    public AppComponent getAppComponent(){

        return  mAppComponent;
    }

    /**
     * 返回主线程的pid
     *
     * @return
     */
    public static int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 返回Handler
     *
     * @return
     */
    public static Handler getHandler() {
        return mHandler;
    }
}
