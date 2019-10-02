package com.hanwu.hill.exception;

/**
 * ApiException
 *
 * @author Sefan
 **/
public class ApiException extends RuntimeException {

    private String code;

    private String message;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String code, String message) {
        this(message);
        this.message = message;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
