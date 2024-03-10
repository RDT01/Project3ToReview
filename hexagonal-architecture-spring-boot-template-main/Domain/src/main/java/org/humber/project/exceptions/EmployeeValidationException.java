package org.humber.project.exceptions;

public class EmployeeValidationException extends RuntimeException {

    private final ErrorCode errorCode;

    public EmployeeValidationException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}