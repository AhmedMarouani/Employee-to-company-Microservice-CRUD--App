package com.example.demo.adapter.to;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyTo {//adapter package is for the communication with microservices other than this one
    private long companyid;
    private String name;
    private int size;
    private String domaine;
    private String employeeid;
}
