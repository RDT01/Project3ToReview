package org.humber.project.services.impl;


import org.humber.project.domain.Overtime;
import org.humber.project.repositories.OvertimeJPARepository;
import org.humber.project.repositories.entities.OvertimeEntity;
import org.humber.project.services.OvertimeJPAService;
import org.humber.project.transformers.OvertimeEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


import static org.humber.project.transformers.OvertimeEntityTransformer.transformToOvertime;
import static org.humber.project.transformers.OvertimeEntityTransformer.transformToOvertimeEntity;


@Service
public class OvertimeJPAServiceImpl implements OvertimeJPAService {


    private final OvertimeJPARepository overtimeJPARepository;


    @Autowired
    public OvertimeJPAServiceImpl(OvertimeJPARepository overtimeJPARepository) {
        this.overtimeJPARepository = overtimeJPARepository;
    }


    @Override
    public Overtime.OvertimeBuilder getOvertimeById(Long Id) {
        return overtimeJPARepository.findById(Id)
                .map(OvertimeEntityTransformer::transformToOvertime)
                .orElse(null);
    }


    @Override
    public List<Overtime.OvertimeBuilder> getAllOvertimes() {
        return Optional.of(overtimeJPARepository.findAll())
                .map(OvertimeEntityTransformer::transformToOvertimes)
                .orElse(null);
    }


    @Override
    public Overtime.OvertimeBuilder saveOvertime(Overtime overtime) {
        OvertimeEntity overtimeEntity = transformToOvertimeEntity(overtime);
        OvertimeEntity savedEntity = overtimeJPARepository.save(overtimeEntity);
        return transformToOvertime(savedEntity);
    }
}
