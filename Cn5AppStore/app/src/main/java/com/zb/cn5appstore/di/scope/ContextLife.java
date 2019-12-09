package com.zb.cn5appstore.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by GuanJunwei on 2019/11/30.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ContextLife {
    String value() ;
}
