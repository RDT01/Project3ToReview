package org.humber.project.services;


import org.humber.project.domain.TimeOff;


public interface TimeOffValidationService {
    void validateTimeOff(TimeOff timeOff);
}
