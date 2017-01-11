package com.yunwei.frame.function.mainFuncations.missionModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.yunwei.frame.R;
import com.yunwei.frame.base.BaseFragment;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.mainFuncations.homeFuncation
 * @Description:任务主界面
 * @date 2016/11/22 18:12
 */

public class MissionFragment extends BaseFragment {

    private static MissionFragment fragment;

    public static MissionFragment newInstance() {
        if (fragment == null) {
            fragment = new MissionFragment();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_fragment_mission, null);
        return rootView;
    }
}
