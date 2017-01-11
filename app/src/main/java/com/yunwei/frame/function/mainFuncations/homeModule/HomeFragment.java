package com.yunwei.frame.function.mainFuncations.homeModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunwei.frame.R;
import com.yunwei.frame.base.BaseFragment;
import com.yunwei.frame.utils.ILog;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.mainFuncations.homeFuncation
 * @Description:主页
 * @date 2016/11/22 18:12
 */

public class HomeFragment extends BaseFragment {
    private final String TAG = getClass().getSimpleName();

    private static HomeFragment fragment;

    public static HomeFragment newInstance() {
        if (fragment == null) {
            fragment = new HomeFragment();
        }
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ILog.d(TAG, "onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment_home, null);
        ILog.d(TAG, "onCreateView");
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ILog.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        ILog.d(TAG, "onPause");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ILog.d(TAG, "onDestroy");
    }
}
