package com.conex.bank.dto;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BaseDataOut implements Serializable {

    private final Integer errorCode;
    private final String errorMsg;
    private final BaseResultOut data;

    public BaseDataOut(IntegrationErrorCode integrationErrorCode, BaseResultOut data) {
        this.errorCode = integrationErrorCode.getMsgCode();
        this.errorMsg = integrationErrorCode.getMsgDesc();
        this.data = data;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public BaseResultOut getData() {
        return data;
    }

}
