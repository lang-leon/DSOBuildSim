package com.langleon.dsobuildsim.api;

import com.langleon.dsobuildsim.exceptions.HasErrorCode;
import com.langleon.dsobuildsim.exceptions.InvalidItemsEquippedException;
import com.langleon.dsobuildsim.exceptions.InvalidTierException;
import com.langleon.dsobuildsim.exceptions.LimitExceededException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({
            InvalidItemsEquippedException.class,
            InvalidTierException.class
    })
    public ResponseEntity<ErrorResponse> handleInvalidInput(RuntimeException e, HttpServletRequest request)
    {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        400,
                        "Invalid request",
                        ((HasErrorCode) e).getErrorCode().name(),
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(LimitExceededException.class)
    public ResponseEntity<ErrorResponse> handleLimitExceeded(LimitExceededException e, HttpServletRequest request)
    {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        400,
                        "Limit exceeded",
                        e.getErrorCode().name(),
                        e.getMessage(),
                        request.getRequestURI()
                ));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e, HttpServletRequest request)
    {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(
                        500,
                        "Internal server error",
                        ErrorCode.INTERNAL_ERROR.name(),
                        "",
                        request.getRequestURI()
                ));
    }
}
