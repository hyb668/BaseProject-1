package com.yunwei.frame.vendor.retrofit;

import com.yunwei.frame.BuildConfig;
import com.yunwei.frame.base.DataApplication;
import com.yunwei.frame.entity.ResponseModel;
import com.yunwei.frame.function.account.data.ModifyHeadEntity;
import com.yunwei.frame.function.account.data.ModifyPasswordEntity;
import com.yunwei.frame.function.account.data.UserInfoEntity;
import com.yunwei.frame.function.mainFuncations.data.QiNiuTokenEntity;
import com.yunwei.frame.function.mainFuncations.mineModule.data.AppVersionEntity;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Url;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.common.retrofit
 * @Description:请求API接口配制
 * @date 2016/11/29 15:50
 */

public interface APIService {
    /**
     * 登录
     *
     * @param entity
     * @return
     */
    @POST(BuildConfig.LOGIN_URL)
    Call<UserInfoEntity> loginRepo(@Body RequestBody entity);

    /**
     * 修改用户信息
     *
     * @param entity
     * @return
     */
    @POST(BuildConfig.MODIFY_USER_HEAD_URL + "{id}")
    Call<ResponseModel> modifyUserInfo(@Body ModifyHeadEntity entity, @Path("id") String id);

    /**
     * 修改用户密码
     *
     * @param entity
     * @return
     */
    @PUT(BuildConfig.MODIFY_USER_PWD_URL + "{id}")
    Call<ResponseModel> modifyUserPassword(@Body ModifyPasswordEntity entity, @Path("id") String id);

    /**
     * 请求七牛Token
     *
     * @return
     */
    @GET(BuildConfig.QINIU_TOKEN_URL)
    Call<ResponseModel<QiNiuTokenEntity>> reqQiniuToken();

    /**
     * 版本检测
     *
     * @return
     */
    @GET(BuildConfig.CHECK_APP_VERSION_URL)
    Call<ResponseModel<AppVersionEntity>> checkAppVersion();

    /**
     * 文件下载
     *
     * @param url
     * @return
     */
    @GET
    Call<ResponseBody> downloadFile(@Url String url);

}
