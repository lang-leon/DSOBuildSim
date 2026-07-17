package com.langleon.dsobuildsim.exceptions;

import com.langleon.dsobuildsim.api.ErrorCode;

public class LimitExceededException extends RuntimeException implements HasErrorCode{

    private final LimitType type;
    private final ErrorCode errorCode = ErrorCode.LIMIT_EXCEEDED;

    public LimitExceededException(LimitType type, String message) {
        super(message);
        this.type = type;
    }

    public LimitType getType() {
        return type;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
