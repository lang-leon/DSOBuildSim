package com.langleon.dsobuildsim.api;

public class ErrorResponse {

    private final int status;
    private final String error;
    private final String errorCode;
    private final String message;
    private final String path;
    private final long timestamp;

    public ErrorResponse(int status, String error, String errorCode, String message, String path) {
        this.status = status;
        this.error = error;
        this.errorCode = errorCode;
        this.message = message;
        this.path = path;
        this.timestamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
