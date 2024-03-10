package org.humber.project.transformers;


import org.humber.project.domain.TimeOff;
import org.humber.project.repositories.entities.TimeOffEntity;


import java.util.List;
import java.util.stream.Collectors;


public final class TimeOffEntityTransformer {


    private TimeOffEntityTransformer() {
    }


    public static TimeOffEntity transformToTimeOffEntity(TimeOff timeOff) {
        TimeOffEntity timeOffEntity = new TimeOffEntity();
        timeOffEntity.setId(timeOff.getId());
        timeOffEntity.setEmployerId((timeOff.getEmployerId()));
        timeOffEntity.setEmployeeId((timeOff.getEmployeeId()));
        timeOffEntity.setVacation_days(timeOff.getVacationDays());
        timeOffEntity.setReason(timeOff.getReason());
        timeOffEntity.setDayOff(timeOff.getDayOff());
        return timeOffEntity;
    }




    public static TimeOff transformToTimeOff(TimeOffEntity timeOffEntity) {
        return TimeOff.builder()
                .Id(timeOffEntity.getId())
                .employerId(timeOffEntity.getEmployerId())
                .employeeId(timeOffEntity.getEmployeeId())
                .vacationDays(timeOffEntity.getVacation_days())
                .reason(timeOffEntity.getReason())
                .dayOff(timeOffEntity.getDayOff())
                .build();
    }


    public static List<TimeOff.TimeOffBuilder> transformToTimeOffs(List<TimeOffEntity> entities) {
        return entities.stream()
                .map(TimeOffEntityTransformer::transformToTimeOff)
                .collect(Collectors.toList());
    }
}
