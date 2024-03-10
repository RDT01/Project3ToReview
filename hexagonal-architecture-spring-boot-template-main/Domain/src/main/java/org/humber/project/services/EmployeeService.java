package org.humber.project.services;

import org.humber.project.domain.Employee;

public interface EmployeeService {

    Employee.EmployeeBuilder createEmployee(Employee employee);

    boolean deleteEmployee(Long Id);

    Employee updateEmployee(Employee employee);

    Employee.EmployeeBuilder getEmployee(Long Id);

}