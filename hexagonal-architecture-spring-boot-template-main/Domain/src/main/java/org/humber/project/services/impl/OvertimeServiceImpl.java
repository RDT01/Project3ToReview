package org.humber.project.services.impl;


import org.humber.project.domain.Overtime;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.OvertimeValidationException;
import org.humber.project.services.OvertimeJPAService;
import org.humber.project.services.OvertimeService;
import org.humber.project.services.OvertimeValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class OvertimeServiceImpl implements OvertimeService {


    private final OvertimeJPAService overtimeJpaService;
    private final List<OvertimeValidationService> validationServices;


    @Autowired
    public OvertimeServiceImpl(OvertimeJPAService overtimeJpaService, List<OvertimeValidationService> validationService) {
        this.overtimeJpaService = overtimeJpaService;
        this.validationServices = validationService;
    }


    @Override
    public Overtime.OvertimeBuilder createOvertime(Overtime overtime) {
        System.out.println("In method createOvertime, validating overtime= " + overtime.toString());
        for (OvertimeValidationService validationService : validationServices) {
            if (validationService instanceof OvertimeIdValidation) {
                System.out.println("Skipping OvertimeIdValidation for new Overtime");
                continue;
            }
            validationService.validateOvertime(overtime);
        }
        System.out.println("Saving overtime");
        return overtimeJpaService.saveOvertime(overtime);
    }


    @Override
    public boolean deleteOvertime(Long Id) {
        System.out.println("Deleting overtime");
        Overtime.OvertimeBuilder overtime = overtimeJpaService.getOvertimeById(Id);
        return overtime != null;
    }


    @Override
    public Overtime updateOvertime(Overtime overtime) {
        //TODO: Implement update overtime
        System.out.println("Updating overtime");
        return null;
    }


    @Override
    public Overtime.OvertimeBuilder getOvertime(Long Id) {
        System.out.println("Getting overtime");
        if(Id == null) {
            System.err.println("Overtime id is null");
            throw new OvertimeValidationException(ErrorCode.INVALID_OVERTIME_ID);
        }
        return overtimeJpaService.getOvertimeById(Id);
    }
}
