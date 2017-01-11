package com.yunwei.frame.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yunwei.frame.utils.ILog;
import com.yunwei.frame.utils.ISystemUtil;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.gas.ui.activity
 * @Description:轮询监听
 * @date 2016/12/1 15:12
 */

    public class PollingReceiver extends BroadcastReceiver {
    private final String TAG = getClass().getSimpleName();

    public static final String ACTION = "com.yunwei.polling";
    /*百度鹰眼服务*/
    public static final String BAIDU_TRACK_SERVICE = "com.baidu.trace.LBSTraceService";

    @Override
    public void onReceive(Context context, Intent intent) {
        ILog.d(TAG, "action===" + intent.getAction());
        /*检测百度鹰眼服务*/
        if (intent.getAction().equals(ACTION)) {
            if (!ISystemUtil.isServiceWork(context, BAIDU_TRACK_SERVICE)) {
            }
        }
    }
}
