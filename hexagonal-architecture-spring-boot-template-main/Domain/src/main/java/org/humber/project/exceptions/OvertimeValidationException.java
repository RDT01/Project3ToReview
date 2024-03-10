package org.humber.project.exceptions;


public class OvertimeValidationException extends RuntimeException {


    private final ErrorCode errorCode;


    public OvertimeValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }


    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
