package com.bbcalife.bbcalife.services;

import com.bbcalife.bbcalife.exceptions.common.ApiException;

public interface ExceptionService {

    void log(ApiException runtimeException);

    void log(RuntimeException runtimeException, int statusCode);
}
