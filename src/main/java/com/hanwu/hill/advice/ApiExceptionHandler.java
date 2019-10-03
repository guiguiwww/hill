package com.hanwu.hill.advice;

import com.hanwu.hill.exception.ApiException;
import com.hanwu.hill.response.ApiResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ApiExceptionHandler.java
 *
 * @author Stefan
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    public ApiResponse restExceptionHandler(ApiException exception) {
        logger.error("Request hill api failed, error: {}", exception);
        return ApiResponse.triggerFailure(exception.getCode(), exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ApiResponse commonExceptionHandler(Exception exception) {
        logger.error("Request hill unknown error, error: {}", exception);
        return ApiResponse.triggerFailure(exception.getMessage());
    }
}
