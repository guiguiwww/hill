package com.hanwu.hill.exception;

/**
 * ApiException
 *
 * @author Sefan
 **/
public class ApiException extends RuntimeException {

    public ApiException(String message) {
        super(message);
    }
}
