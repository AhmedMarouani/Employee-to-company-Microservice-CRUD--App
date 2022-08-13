package com.example.demo.controller.To;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyTo {
    private long companyid;
    private String name;
    private int size;
    private String domaine;
    private int employeeid;
}
