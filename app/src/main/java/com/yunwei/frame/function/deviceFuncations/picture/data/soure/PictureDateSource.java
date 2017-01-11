package com.yunwei.frame.function.deviceFuncations.picture.data.soure;

import com.yunwei.frame.function.deviceFuncations.picture.data.PictureEntity;

import java.util.List;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.deviceFuncations.picture.data.soure
 * @Description:
 * @date 2016/12/29 11:35
 */

public interface PictureDateSource {

    interface QueryAlbumCallBack {
        void getAlbumSuccess(List<PictureEntity> lists);

        void getAlbumFailure();
    }

    void queryAlbumAction(QueryAlbumCallBack callBack);
}
