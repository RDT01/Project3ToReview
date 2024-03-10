package org.humber.project.services.impl;


import lombok.NonNull;
import org.humber.project.domain.TimeOff;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.TimeOffValidationException;
import org.humber.project.services.TimeOffValidationService;
import org.springframework.stereotype.Component;


@Component
public class TimeOffIdValidation implements TimeOffValidationService {
    @Override
    public void validateTimeOff(@NonNull TimeOff timeOff) {
        if(timeOff.getId() == null) {
            System.err.println("TimeOff id is null");
            throw new TimeOffValidationException(ErrorCode.INVALID_TIMEOFF_ID);
        }
    }
}
