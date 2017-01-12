package com.yunwei.frame.base;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.google.gson.Gson;
import com.yunwei.frame.BuildConfig;
import com.yunwei.frame.common.Constant;
import com.yunwei.frame.function.account.data.UserInfoEntity;
import com.yunwei.frame.service.MonitorService;
import com.yunwei.frame.utils.ISpfUtil;
import com.yunwei.frame.vendor.baiduTrack.BaiduTrack;
import com.yunwei.frame.vendor.qiniu.QiNiuConfig;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.base
 * @Description:Application类
 * @date 2016/11/22 14:59
 */

public class DataApplication extends Application {
    private String TAG = getClass().getSimpleName();

    private static DataApplication instance;

    /*定位Client*/
    private AMapLocationClient mLocationClient;
    /*定位option*/
    private AMapLocationClientOption locationClientOption;
    /*监控服务*/
    private MonitorService monitorService;

    /*百度Track*/
    protected BaiduTrack baiduTrack;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        /*初始化七年配制*/
        QiNiuConfig.iniConfig(BuildConfig.QINIU_DOMAIN, BuildConfig.QINIU_FILENAME);
    }

    public static DataApplication getInstance() {
        return instance;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        /*分包处理 DEX*/
        MultiDex.install(getApplicationContext());
    }

    /**
     * 初始化定位参数
     */
    private void initLocationClient(MonitorService service) {
        if (mLocationClient == null) {
            mLocationClient = new AMapLocationClient(getApplicationContext());

            locationClientOption = new AMapLocationClientOption();
            locationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);//高精度
            locationClientOption.setNeedAddress(true);
            locationClientOption.setInterval(4 * 1000);

            mLocationClient.setLocationOption(locationClientOption);
            mLocationClient.setLocationListener(service);
        }
    }

    /**
     * 启动定位
     */
    public void startLocation(MonitorService service) {
        initLocationClient(service);
        mLocationClient.startLocation();
    }

    /**
     * 停止定位服务
     */
    public void stopLocationService() {
        if (mLocationClient != null) {
            mLocationClient.stopLocation();
        }
    }

    /**
     * 销毁定位服务
     */
    public void destoryLocation() {
        mLocationClient = null;
        locationClientOption = null;
        if (mLocationClient != null) {
            mLocationClient.onDestroy();
        }
    }

    /**
     * 初始化百度鹰眼服务
     */
    private void initBaiduTrack() {
        if (baiduTrack == null) {
            baiduTrack = BaiduTrack.getInstance();
            baiduTrack.setSERVICE_ID(BuildConfig.BAIDUTRACK_SERVICE_ID);
            baiduTrack.setENTITY_NAME(BuildConfig.BAIDUTRACK_ENTITY_NAME + ISpfUtil.getValue(Constant.ACCESS_TOKEN_KEY, "").toString());
        }
    }

    /**
     * 启动百度Track服务
     */
    public void startBaiduTrack() {
        initBaiduTrack();
        baiduTrack.startTrace(getApplicationContext());
    }

    /**
     * 停止百度Track服务
     */
    public void stopBaiduTrack() {
        if (baiduTrack != null) {
            baiduTrack.stopTrace();
        }
    }

    /**
     * 注销百度Track
     */
    public void destroyBaiduTrack() {
        if (baiduTrack != null) {
            baiduTrack.destroy();
        }
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public UserInfoEntity getUserInfoEntity() {
        String string = ISpfUtil.getValue(Constant.USERINFO_KEY, "").toString();
        UserInfoEntity entity = new Gson().fromJson(string, UserInfoEntity.class);
        return entity;
    }


    public MonitorService getMonitorService() {
        return monitorService;
    }

    public void setMonitorService(MonitorService monitorService) {
        this.monitorService = monitorService;
    }
}
