package com.yunwei.frame.function.mainFuncations.data;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.mainFuncations.data
 * @Description:
 * @date 2016/12/23 16:10
 */

public class QiNiuTokenEntity {

    private String Token;
    private String Bucket;
    private String Domain;

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public String getBucket() {
        return Bucket;
    }

    public void setBucket(String bucket) {
        Bucket = bucket;
    }

    public String getDomain() {
        return Domain;
    }

    public void setDomain(String domain) {
        Domain = domain;
    }
}
