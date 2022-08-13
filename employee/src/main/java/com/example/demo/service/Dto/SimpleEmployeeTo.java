package com.example.demo.service.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleEmployeeTo {
    private long employeeid;
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private int salary;
    private long companyid;
}
