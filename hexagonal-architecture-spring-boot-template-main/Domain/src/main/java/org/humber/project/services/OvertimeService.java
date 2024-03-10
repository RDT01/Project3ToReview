package org.humber.project.services;


import org.humber.project.domain.Overtime;


public interface OvertimeService {


    Overtime.OvertimeBuilder createOvertime(Overtime overtime);


    boolean deleteOvertime(Long Id);


    Overtime updateOvertime(Overtime overtime);


    Overtime.OvertimeBuilder getOvertime(Long Id);


}
