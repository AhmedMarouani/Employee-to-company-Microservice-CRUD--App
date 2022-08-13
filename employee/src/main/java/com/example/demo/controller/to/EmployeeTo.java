package com.example.demo.controller.to;

import com.example.demo.adapter.to.CompanyTo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTo {
    //to get employee and company in the same controller class
    //first we create 2 classes (employeeTo and CompanyTo)
    private long employeeid;
    private String firstname;
    private String lastname;
    private String email;
    private int age;
    private int salary;
    private long companyid;
    private String companyname;
}
