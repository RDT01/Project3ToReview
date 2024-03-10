package org.humber.project.services.impl;

import org.humber.project.domain.Employee;
import org.humber.project.exceptions.ErrorCode;
import org.humber.project.exceptions.EmployeeValidationException;
import org.humber.project.services.EmployeeJPAService;
import org.humber.project.services.EmployeeService;
import org.humber.project.services.EmployeeValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeJPAService employeeJpaService;
    private final List<EmployeeValidationService> validationServices;

    @Autowired
    public EmployeeServiceImpl(EmployeeJPAService employeeJpaService, List<EmployeeValidationService> validationService) {
        this.employeeJpaService = employeeJpaService;
        this.validationServices = validationService;
    }

    @Override
    public Employee.EmployeeBuilder createEmployee(Employee employee) {
        System.out.println("In method createEmployee, validating employee= " + employee.toString());
        for (EmployeeValidationService validationService : validationServices) {
            if (validationService instanceof EmployeeIdValidation) {
                System.out.println("Skipping EmployeeIdValidation for new Employee");
                continue;
            }
            validationService.validateEmployee(employee);
        }
        System.out.println("Saving employee");
        return employeeJpaService.saveEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(Long Id) {
        System.out.println("Deleting employee");
        Employee.EmployeeBuilder employee = employeeJpaService.getEmployeeById(Id);
        return employee != null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        //TODO: Implement update employee
        System.out.println("Updating employee");
        return null;
    }

    @Override
    public Employee.EmployeeBuilder getEmployee(Long Id) {
        System.out.println("Getting employee");
        if(Id == null) {
            System.err.println("Employee id is null");
            throw new EmployeeValidationException(ErrorCode.INVALID_EMPLOYEE_ID);
        }
        return employeeJpaService.getEmployeeById(Id);
    }
}
