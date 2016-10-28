package com.conex.bank.dto;

public enum IntegrationErrorCode {

    _0(null),
    _1001("not a number");

    private final Integer msgCode;
    private final String msgDesc;

    private IntegrationErrorCode(String msgDesc) {
        this.msgCode = Integer.valueOf(this.name().replace("_", ""));
        this.msgDesc = msgDesc;
    }

    public Integer getMsgCode() {
        return msgCode;
    }

    public String getMsgDesc() {
        return msgDesc;
    }

}
