package com.conex.bank.controller;

import java.io.IOException;

import com.conex.bank.dto.BaseDataOut;
import com.conex.bank.dto.BaseResultOut;
import com.conex.bank.dto.IntegrationErrorCode;

public abstract class BaseController {
    
    protected BaseDataOut writeSuccessDataOut(BaseResultOut baseResultOut) throws IOException {
        return new BaseDataOut(IntegrationErrorCode._0, baseResultOut);
    }
    
    protected BaseDataOut writeErrorDataOut(IntegrationErrorCode integrationErrorCode) throws IOException {
        return new BaseDataOut(integrationErrorCode, null);
    }
    
}
