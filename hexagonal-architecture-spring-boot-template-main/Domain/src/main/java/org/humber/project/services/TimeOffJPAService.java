package org.humber.project.services;


import org.humber.project.domain.TimeOff;


import java.util.List;


public interface TimeOffJPAService {


    TimeOff.TimeOffBuilder getTimeOffById(Long Id);


    List<TimeOff.TimeOffBuilder> getAllTimeOffs();


    TimeOff.TimeOffBuilder saveTimeOff(TimeOff timeOff);


}
