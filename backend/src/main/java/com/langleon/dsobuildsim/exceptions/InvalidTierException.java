package com.langleon.dsobuildsim.exceptions;

import com.langleon.dsobuildsim.api.ErrorCode;

public class InvalidTierException extends RuntimeException implements HasErrorCode{

    private final ErrorCode errorCode = ErrorCode.INVALID_TIER;

    public InvalidTierException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
