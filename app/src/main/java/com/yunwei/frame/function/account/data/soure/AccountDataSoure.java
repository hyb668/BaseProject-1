package com.yunwei.frame.function.account.data.soure;

import com.yunwei.frame.function.account.data.ModifyHeadEntity;
import com.yunwei.frame.function.account.data.ModifyPasswordEntity;
import com.yunwei.frame.function.account.data.UserInfoEntity;
import com.yunwei.frame.base.BaseDataSourse;

import okhttp3.RequestBody;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.account.data.soure
 * @Description:
 * @date 2016/11/29 15:02
 */

public interface AccountDataSoure extends BaseDataSourse {

    interface LoginCallBack {

        void onLoginSuccess(UserInfoEntity entity);

        void onLoginFailure(String error);

    }

    interface ModifyHeadCallBack {
        void onModifyHeadSuccess(String headNewPath);

        void onModifyHeadFailure(String error);

        ModifyHeadEntity getHeadBody(String path);
    }

    interface ModifyPasswordCallBack {
        void onModifyPasswordSuccess();

        void onModifyPasswordFailure(String error);

        ModifyPasswordEntity getPasswordBody();
    }

    void login(String account, String password, LoginCallBack callBack);

    void modifyHead(String path, ModifyHeadCallBack callBack);

    void modifyPassword(ModifyPasswordCallBack callBack);
}
