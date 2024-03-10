package org.humber.project.transformers;


import org.humber.project.domain.Overtime;
import org.humber.project.repositories.entities.OvertimeEntity;


import java.util.List;
import java.util.stream.Collectors;


public final class OvertimeEntityTransformer {


    private OvertimeEntityTransformer() {
    }


    public static OvertimeEntity transformToOvertimeEntity(Overtime overtime) {
        OvertimeEntity studentEntity = new OvertimeEntity();
        studentEntity.setId(overtime.getId());
        studentEntity.setEmployeeId(overtime.getEmployeeId());
        studentEntity.setFirstname((overtime.getFirstname()));
        studentEntity.setLastname((overtime.getLastname()));
        studentEntity.setHours(overtime.getHours());
        return studentEntity;
    }




    public static Overtime.OvertimeBuilder transformToOvertime(OvertimeEntity overtimeEntity) {
        return Overtime.builder()
                .Id(overtimeEntity.getId())
                .employeeId(overtimeEntity.getEmployeeId())
                .firstname(overtimeEntity.getFirstname())
                .lastname(overtimeEntity.getLastname())
                .hours(overtimeEntity.getHours());
    }


    public static List<Overtime.OvertimeBuilder> transformToOvertimes(List<OvertimeEntity> entities) {
        return entities.stream()
                .map(OvertimeEntityTransformer::transformToOvertime)
                .collect(Collectors.toList());
    }
}
