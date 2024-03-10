package org.humber.project.services.impl;

import lombok.NonNull;
import org.humber.project.domain.Employee;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.EmployeeValidationException;
import org.humber.project.services.EmployeeValidationService;
import org.springframework.stereotype.Component;

@Component
public class EmployeeIdValidation implements EmployeeValidationService {
    @Override
    public void validateEmployee(@NonNull Employee employee) {
        if(employee.getId() == null) {
            System.err.println("Employee id is null");
            throw new EmployeeValidationException(ErrorCode.INVALID_EMPLOYEE_ID);
        }
    }
}