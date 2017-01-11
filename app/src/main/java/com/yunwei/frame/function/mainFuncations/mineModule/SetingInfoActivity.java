package com.yunwei.frame.function.mainFuncations.mineModule;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;

import com.yunwei.frame.R;
import com.yunwei.frame.base.BaseActivity;
import com.yunwei.frame.function.mainFuncations.mineModule.fragment.AboutFragment;
import com.yunwei.frame.function.mainFuncations.mineModule.fragment.MessageSetingFragment;
import com.yunwei.frame.function.mainFuncations.mineModule.fragment.TrackSetingFragment;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.mainFuncations.mineFuncation
 * @Description:
 * @date 2016/11/28 10:18
 */

public class SetingInfoActivity extends BaseActivity {

    public static final String HEAD_TITLE_FLAG = "title_flag";
    public static final String SHOW_FRAGMENT_FLAG = "show_flag";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_seting_info);
        String fromFlag = getIntent().getStringExtra(SHOW_FRAGMENT_FLAG);
        initUI(fromFlag);
    }

    /**
     * 初始化UI
     *
     * @param flag
     */
    private void initUI(String flag) {
        if (TextUtils.isEmpty(flag)) {
            return;
        }
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        if (flag.equals(MessageSetingFragment.FRAGMENT_FLAG)) {
            setToolbarTitle(R.string.set_msg_info);
            transaction.replace(R.id.seting_info_container, MessageSetingFragment.newInstance());
        } else if (flag.equals(TrackSetingFragment.FRAGMENT_FLAG)) {
            setToolbarTitle(R.string.set_track_info);
            transaction.replace(R.id.seting_info_container, TrackSetingFragment.newInstance());
        } else if (flag.equals(AboutFragment.FRAGMENT_FLAG)) {
            setToolbarTitle(R.string.set_about);
            transaction.replace(R.id.seting_info_container, AboutFragment.newInstance());
        }
        transaction.commit();
    }
}
