package org.humber.project.services;


import org.humber.project.domain.Overtime;


import java.util.List;


public interface OvertimeJPAService {


    Overtime.OvertimeBuilder getOvertimeById(Long Id);


    List<Overtime.OvertimeBuilder> getAllOvertimes();


    Overtime.OvertimeBuilder saveOvertime(Overtime overtime);


}
