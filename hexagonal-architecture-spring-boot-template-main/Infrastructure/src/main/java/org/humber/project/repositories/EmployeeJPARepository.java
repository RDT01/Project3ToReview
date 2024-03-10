package org.humber.project.repositories;

import org.humber.project.repositories.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeJPARepository extends JpaRepository<EmployeeEntity, Long> {

}