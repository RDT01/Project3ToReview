package org.humber.project.services.impl;

import lombok.NonNull;
import org.humber.project.domain.Employee;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.EmployeeValidationException;
import org.humber.project.services.EmployeeValidationService;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class EmployeeNameValidation implements EmployeeValidationService {
    @Override
    public void validateEmployee(@NonNull Employee employee) {
        if (employee.getLastname() == null || !StringUtils.hasLength(employee.getLastname().trim())) {
            System.err.println("Employee name is null");
            throw new EmployeeValidationException(ErrorCode.INVALID_EMPLOYEE_NAME);
        }
    }
}