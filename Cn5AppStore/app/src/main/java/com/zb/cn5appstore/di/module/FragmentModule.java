package com.zb.cn5appstore.di.module;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;

import com.zb.cn5appstore.di.scope.ContextLife;
import com.zb.cn5appstore.di.scope.PerFragment;

import dagger.Module;
import dagger.Provides;

/**
 * Created by GuanJunwei on 2019/11/30.
 */
@Module
public class FragmentModule {

    private Fragment mFragment ;

    public FragmentModule(Fragment fragment){
        this.mFragment = fragment ;
    }

    @Provides
    @PerFragment
    @ContextLife("Activity")
    public Context provideFragmentContext(){
        return mFragment.getContext() ;
    }

    @Provides
    @PerFragment
    public Activity provideActivity(){
        return mFragment.getActivity() ;
    }

    @Provides
    @PerFragment
    public Fragment provideFragment(){
        return mFragment ;
    }

}
