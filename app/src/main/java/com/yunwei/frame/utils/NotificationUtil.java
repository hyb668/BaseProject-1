package com.yunwei.frame.utils;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;

import com.yunwei.frame.R;
import com.yunwei.frame.base.DataApplication;
import com.yunwei.frame.function.mainFuncations.MainActivity;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.utils
 * @Description:Notification 工具类
 * @date 2016/12/5 15:44
 */

public class NotificationUtil {

    /**
     * 发起通知
     *
     * @return
     */
    public static Notification sendNotification(String contentTitle, String contentText, Class<MainActivity> activity) {
        Notification.Builder builder = new Notification.Builder(DataApplication.getInstance().getApplicationContext());
        Intent intent = new Intent(DataApplication.getInstance().getApplicationContext(), activity);
        builder.setContentIntent(PendingIntent.getActivity(DataApplication.getInstance(), 0, intent, 0)) // 设置PendingIntent
                .setLargeIcon(BitmapFactory.decodeResource(DataApplication.getInstance().getResources(), R.mipmap.ic_launcher)) // 设置下拉列表中的图标(大图标)
                .setContentTitle(contentTitle) // 设置下拉列表里的标题
                .setSmallIcon(R.mipmap.ic_launcher) // 设置状态栏内的小图标
                .setContentText(contentText) // 设置上下文内容
                .setWhen(System.currentTimeMillis()); // 设置该通知发生的时间
        return builder.build();
    }
}
