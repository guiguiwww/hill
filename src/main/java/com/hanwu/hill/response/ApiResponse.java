package com.hanwu.hill.response;

import java.io.Serializable;

/**
 * ApiResponse.java
 *
 * @author Stefan
 *
 * <p>Api response common class</p>
 */
public class ApiResponse<T> implements Serializable {

    private boolean isSuccess = Boolean.FALSE;

    private String requestId;

    private Error error;

    private T content;

    public ApiResponse() {

    }

    private ApiResponse(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    private ApiResponse(Boolean isSuccess, Error error) {
        this(isSuccess);
        this.error = error;
    }

    private ApiResponse(Boolean isSuccess, T content) {
        this(isSuccess);
        this.content = content;
    }

    @SuppressWarnings("unchecked")
    public static <R> ApiResponse triggerSuccess(R content) {
        return new ApiResponse(Boolean.TRUE, content);
    }

    public static ApiResponse triggerFailure(String errorCode, String errorMessage) {
        return new ApiResponse(Boolean.FALSE, new Error(errorCode, errorMessage));
    }

    @SuppressWarnings("unchecked")
    public static ApiResponse triggerFailure(String message) {
        return new ApiResponse(Boolean.FALSE, message);
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    /**
     * Error Common Class
     */
    static class Error {
        private String errorCode;

        private String errorMessage;

        private Error() {

        }

        private Error(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(String errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(String errorMessage) {
            this.errorMessage = errorMessage;
        }
    }

}
