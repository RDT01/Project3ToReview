package org.humber.project.services;


import org.humber.project.domain.TimeOff;


public interface TimeOffService {


    TimeOff.TimeOffBuilder createTimeOff(TimeOff timeOff);


    boolean deleteTimeOff(Long Id);


    TimeOff updateTimeOff(TimeOff timeOff);


    TimeOff.TimeOffBuilder getTimeOff(Long Id);


}
