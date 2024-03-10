package org.humber.project.repositories;


import org.humber.project.repositories.entities.OvertimeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OvertimeJPARepository extends JpaRepository<OvertimeEntity, Long> {


}
