package org.humber.project.services;

import org.humber.project.domain.Employee;

import java.util.List;

public interface EmployeeJPAService {

    Employee.EmployeeBuilder getEmployeeById(Long Id);

    List<Employee.EmployeeBuilder> getAllEmployees();

    Employee.EmployeeBuilder saveEmployee(Employee employee);

}