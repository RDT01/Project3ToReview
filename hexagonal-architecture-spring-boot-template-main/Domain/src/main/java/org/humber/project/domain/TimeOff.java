package org.humber.project.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeOff {
    private Long Id;
    private Integer employerId;
    private Integer employeeId;
    private Integer vacationDays;
    private String reason;
    private String dayOff;

}