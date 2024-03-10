package org.humber.project.repositories;

import org.humber.project.repositories.entities.TimeOffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeOffJPARepository extends JpaRepository<TimeOffEntity, Long> {

}