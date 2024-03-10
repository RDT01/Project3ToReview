package org.humber.project.services;


import org.humber.project.domain.Overtime;


public interface OvertimeValidationService {
    void validateOvertime(Overtime overtime);
}
