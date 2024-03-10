package org.humber.project.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Overtime {
    private Long Id;
    private Integer employeeId;
    private String firstname;
    private String lastname;
    private Double hours;
}
