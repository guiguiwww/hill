package com.hanwu.hill.response;

/**
 * ApiResponse.java
 *
 * @author Stefan
 *
 * <p>Api response common class</p>
 */
public class ApiResponse<T> {

    private boolean isSuccess = Boolean.FALSE;

    private String requestId;

    private Error error;

    private T content;

    public ApiResponse() {

    }

    public ApiResponse(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public ApiResponse(Boolean isSuccess, Error error) {
        this(isSuccess);
        this.error = error;
    }

    public ApiResponse(Boolean isSuccess, T content) {
        this(isSuccess);
        this.content = content;
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
    class Error {
        private String errorCode;

        private String errorMessage;

        public Error() {

        }

        public Error(String errorCode, String errorMessage) {
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
