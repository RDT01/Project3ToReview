package org.humber.project.services.impl;

import org.humber.project.domain.Employee;
import org.humber.project.repositories.EmployeeJPARepository;
import org.humber.project.repositories.entities.EmployeeEntity;
import org.humber.project.services.EmployeeJPAService;
import org.humber.project.transformers.EmployeeEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.humber.project.transformers.EmployeeEntityTransformer.transformToEmployee;
import static org.humber.project.transformers.EmployeeEntityTransformer.transformToEmployeeEntity;

@Service
public class EmployeeJPAServiceImpl implements EmployeeJPAService {

    private final EmployeeJPARepository employeeJPARepository;

    @Autowired
    public EmployeeJPAServiceImpl(EmployeeJPARepository employeeJPARepository) {
        this.employeeJPARepository = employeeJPARepository;
    }

    @Override
    public Employee.EmployeeBuilder getEmployeeById(Long Id) {
        return employeeJPARepository.findById(Id)
                .map(EmployeeEntityTransformer::transformToEmployee)
                .orElse(null);
    }

    @Override
    public List<Employee.EmployeeBuilder> getAllEmployees() {
        return Optional.of(employeeJPARepository.findAll())
                .map(EmployeeEntityTransformer::transformToEmployees)
                .orElse(null);
    }

    @Override
    public Employee.EmployeeBuilder saveEmployee(Employee employee) {
        EmployeeEntity employeeEntity = transformToEmployeeEntity(employee);
        EmployeeEntity savedEntity = employeeJPARepository.save(employeeEntity);
        return transformToEmployee(savedEntity);
    }
}