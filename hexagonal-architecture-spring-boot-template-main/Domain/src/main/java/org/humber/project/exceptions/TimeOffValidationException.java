package org.humber.project.exceptions;


public class TimeOffValidationException extends RuntimeException {


    private final ErrorCode errorCode;


    public TimeOffValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
