package com.langleon.dsobuildsim.exceptions;

import com.langleon.dsobuildsim.api.ErrorCode;

public class InvalidItemsEquippedException extends RuntimeException implements HasErrorCode{

    private final ErrorCode errorCode = ErrorCode.INVALID_ITEMS_EQUIPPED;

    public InvalidItemsEquippedException(String message) {
        super(message);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
