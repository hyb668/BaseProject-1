package com.yunwei.frame.utils;

import com.yunwei.frame.base.DataApplication;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.utils
 * @Description:工具类
 * @date 2016/11/30 11:03
 */

public class IUtil {

    /**
     * 获取字符串资源
     *
     * @param res
     * @return
     */
    public static String getStrToRes(int res) {
        return DataApplication.getInstance().getResources().getString(res);
    }

    /**
     * Url过滤
     *
     * @param url
     * @return
     */
    public static String fitterUrl(String url) {
        if (!url.contains("http://")) {
            url = "file://" + url;
        }
        return url;
    }
}
