package com.xcp.designpatterns.mvp_proxy;

/**
 * Created by Administrator on 2018/10/26
 */
public class ErrorInfo {

    private String code;
    private String errorMessage;

    public ErrorInfo(String code, String errorMessage) {
        this.code = code;
        this.errorMessage = errorMessage;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

