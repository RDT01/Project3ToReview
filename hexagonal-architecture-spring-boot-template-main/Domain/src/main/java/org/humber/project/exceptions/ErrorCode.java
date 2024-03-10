package org.humber.project.exceptions;

public enum ErrorCode {
    INVALID_EMPLOYEE_ID("Invalid employee id"),
    INVALID_EMPLOYEE_NAME("Invalid employee name"),

    INVALID_TIMEOFF_ID("Invalid request id"),

    INVALID_OVERTIME_ID("Invalid overtime request id");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}