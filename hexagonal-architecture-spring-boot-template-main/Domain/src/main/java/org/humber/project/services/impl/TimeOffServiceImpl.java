package org.humber.project.services.impl;


import org.humber.project.domain.TimeOff;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.TimeOffValidationException;
import org.humber.project.services.TimeOffJPAService;
import org.humber.project.services.TimeOffService;
import org.humber.project.services.TimeOffValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TimeOffServiceImpl implements TimeOffService {


    private final TimeOffJPAService timeOffJpaService;
    private final List<TimeOffValidationService> validationServices;


    @Autowired
    public TimeOffServiceImpl(TimeOffJPAService timeOffJpaService, List<TimeOffValidationService> validationService) {
        this.timeOffJpaService = timeOffJpaService;
        this.validationServices = validationService;
    }


    @Override
    public TimeOff.TimeOffBuilder createTimeOff(TimeOff timeOff) {
        System.out.println("In method createTimeOff, validating timeOff= " + timeOff.toString());
        for (TimeOffValidationService validationService : validationServices) {
            if (validationService instanceof TimeOffIdValidation) {
                System.out.println("Skipping TimeOffIdValidation for new TimeOff");
                continue;
            }
            validationService.validateTimeOff(timeOff);
        }
        System.out.println("Saving timeOff");
        return timeOffJpaService.saveTimeOff(timeOff);
    }


    @Override
    public boolean deleteTimeOff(Long Id) {
        System.out.println("Deleting timeOff");
        TimeOff.TimeOffBuilder timeOff = timeOffJpaService.getTimeOffById(Id);
        return timeOff != null;
    }


    @Override
    public TimeOff updateTimeOff(TimeOff timeOff) {
        //TODO: Implement update timeOff
        System.out.println("Updating timeOff");
        return null;
    }


    @Override
    public TimeOff.TimeOffBuilder getTimeOff(Long Id) {
        System.out.println("Getting timeOff");
        if(Id == null) {
            System.err.println("TimeOff id is null");
            throw new TimeOffValidationException(ErrorCode.INVALID_TIMEOFF_ID);
        }
        return timeOffJpaService.getTimeOffById(Id);
    }
}
