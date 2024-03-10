package org.humber.project.repositories.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "timeOff")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeOffEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;


    @Column(name = "employerId")
    private Integer employerId;


    @Column(name = "employeeId")
    private Integer employeeId;


    @Column(name = "vacation_days")
    private Integer vacation_days;

    @Column(name = "reason")
    private String reason;

    @Column(name = "dayOff")
    private String dayOff;

}
