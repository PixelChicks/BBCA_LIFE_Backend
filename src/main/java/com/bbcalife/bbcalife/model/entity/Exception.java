package com.bbcalife.bbcalife.model.entity;

import com.bbcalife.bbcalife.enums.ExceptionSeverity;
import com.bbcalife.bbcalife.exceptions.common.ApiException;
import com.bbcalife.bbcalife.model.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Arrays;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exception extends BaseEntity {
    private Integer statusCode;
    private String exceptionType;
    private String exceptionMessage;
    private String stackTraceString;
    private String methodName;
    private String className;
    private Integer lineNumber;
    @Enumerated(EnumType.STRING)
    private ExceptionSeverity severity;

    public static Exception mapFromRuntimeException(RuntimeException runtimeException, int statusCode) {
        // Exception Info
        String exceptionType = runtimeException.getClass().getName();
        String exceptionMessage = runtimeException.getMessage();

        // Stack Trace
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        String stackTraceString = Arrays.toString(stackTrace);

        // Application Context
        String methodName = stackTrace[0].getMethodName();
        String className = stackTrace[0].getClassName();
        int lineNumber = stackTrace[0].getLineNumber();

        return Exception.builder()
                .statusCode(statusCode)
                .exceptionType(exceptionType)
                .exceptionMessage(exceptionMessage)
                .stackTraceString(stackTraceString)
                .methodName(methodName)
                .className(className)
                .lineNumber(lineNumber)
                .severity(ExceptionSeverity.CRITICAL)
                .build();
    }

    public static Exception mapFromApiException(ApiException apiException) {
        Exception exception = mapFromRuntimeException(apiException, apiException.getStatusCode());
        exception.setSeverity(ExceptionSeverity.INFORMATIONAL);

        return exception;
    }
}
