package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employees_id_sequence")
    @SequenceGenerator(name = "employees_id_sequence", allocationSize = 1)
    private long employeeid;
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private int salary;
    private long companyid;
}
