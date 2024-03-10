package org.humber.project.services.impl;


import org.humber.project.domain.TimeOff;
import org.humber.project.repositories.TimeOffJPARepository;
import org.humber.project.repositories.entities.TimeOffEntity;
import org.humber.project.services.TimeOffJPAService;
import org.humber.project.transformers.TimeOffEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


import static org.humber.project.transformers.TimeOffEntityTransformer.transformToTimeOff;
import static org.humber.project.transformers.TimeOffEntityTransformer.transformToTimeOffEntity;


@Service
public class TimeOffJPAServiceImpl implements TimeOffJPAService {


    private final TimeOffJPARepository timeOffJPARepository;


    @Autowired
    public TimeOffJPAServiceImpl(TimeOffJPARepository timeOffJPARepository) {
        this.timeOffJPARepository = timeOffJPARepository;
    }


    @Override
    public TimeOff.TimeOffBuilder getTimeOffById(Long Id) {
        return timeOffJPARepository.findById(Id)
                .map(TimeOffEntityTransformer::transformToTimeOff)
                .orElse(null);
    }


    @Override
    public List<TimeOff.TimeOffBuilder> getAllTimeOffs() {
        return Optional.of(timeOffJPARepository.findAll())
                .map(TimeOffEntityTransformer::transformToTimeOffs)
                .orElse(null);
    }


    @Override
    public TimeOff.TimeOffBuilder saveTimeOff(TimeOff timeOff) {
        TimeOffEntity timeOffEntity = transformToTimeOffEntity(timeOff);
        TimeOffEntity savedEntity = timeOffJPARepository.save(timeOffEntity);
        return transformToTimeOff(savedEntity);
    }
}
