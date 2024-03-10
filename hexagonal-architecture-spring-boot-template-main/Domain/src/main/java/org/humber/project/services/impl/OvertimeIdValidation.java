package org.humber.project.services.impl;


import lombok.NonNull;
import org.humber.project.domain.Overtime;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.OvertimeValidationException;
import org.humber.project.services.OvertimeValidationService;
import org.springframework.stereotype.Component;


@Component
public class OvertimeIdValidation implements OvertimeValidationService {
    @Override
    public void validateOvertime(@NonNull Overtime overtime) {
        if(overtime.getId() == null) {
            System.err.println("Overtime id is null");
            throw new OvertimeValidationException(ErrorCode.INVALID_OVERTIME_ID);
        }
    }
}
