package com.zb.cn5appstore.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zb.cn5appstore.R;
import com.zb.cn5appstore.base.BaseFragment;

/**
 * Created by VULCAN on 2019/11/17.
 */

public class AppManagerFragment extends BaseFragment{


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_manager, container, false);

    }


}
