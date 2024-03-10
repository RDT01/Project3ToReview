package org.humber.project.transformers;

import org.humber.project.domain.Employee;
import org.humber.project.repositories.entities.EmployeeEntity;

import java.util.List;
import java.util.stream.Collectors;

public final class EmployeeEntityTransformer {

    private EmployeeEntityTransformer() {
    }

    public static EmployeeEntity transformToEmployeeEntity(Employee employee) {
        EmployeeEntity studentEntity = new EmployeeEntity();
        studentEntity.setId(employee.getId());
        studentEntity.setFirstname((employee.getFirstname()));
        studentEntity.setLastname((employee.getLastname()));
        studentEntity.setVacation_days(employee.getVacationDays());
        return studentEntity;
    }


    public static Employee.EmployeeBuilder transformToEmployee(EmployeeEntity employeeEntity) {
        return Employee.builder()
                .Id(employeeEntity.getId())
                .firstname(employeeEntity.getFirstname())
                .lastname(employeeEntity.getLastname())
                .vacationDays(employeeEntity.getVacation_days());
    }

    public static List<Employee.EmployeeBuilder> transformToEmployees(List<EmployeeEntity> entities) {
        return entities.stream()
                .map(EmployeeEntityTransformer::transformToEmployee)
                .collect(Collectors.toList());
    }
}
