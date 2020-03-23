package com.xcp.designpatterns.mvp_proxy;

/**
 * Created by 许成谱 on 2019/6/17 10:20.
 * qq:1550540124
 * 热爱生活每一天！
 */
public class RequestResult<T> {
    private T data;
    private String errorCode;
    private String errorMsg;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
