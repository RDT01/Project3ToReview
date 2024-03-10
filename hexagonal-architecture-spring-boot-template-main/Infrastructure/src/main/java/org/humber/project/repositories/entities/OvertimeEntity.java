package org.humber.project.repositories.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "overtime")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OvertimeEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;


    @Column(name = "employeeId")
    private Integer employeeId;


    @Column(name = "firstname")
    private String firstname;


    @Column(name = "lastname")
    private String lastname;


    @Column(name = "hours")
    private Double hours;
}
