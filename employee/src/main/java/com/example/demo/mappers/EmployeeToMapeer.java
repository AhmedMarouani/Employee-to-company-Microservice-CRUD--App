package com.example.demo.mappers;

import com.example.demo.adapter.to.CompanyTo;
import com.example.demo.controller.to.EmployeeTo;
import com.example.demo.model.EmployeeEntity;

public class EmployeeToMapeer {
    //this is called SINGLE RESPONSIBILITY
    public static EmployeeTo maptoemployeeTo(EmployeeEntity employeeEntity, String companyName) {
        EmployeeTo employeeTo = new EmployeeTo();
        employeeTo.setEmployeeid(employeeEntity.getEmployeeid());
        employeeTo.setFirstname(employeeEntity.getFirstname());
        employeeTo.setLastname(employeeEntity.getLastname());
        employeeTo.setAge(employeeEntity.getAge());
        employeeTo.setSalary(employeeEntity.getSalary());
        employeeTo.setCompanyid(employeeEntity.getCompanyid());
        employeeTo.setEmail(employeeEntity.getEmail());
        employeeTo.setCompanyname(companyName);
        return employeeTo;
    }

    public static EmployeeEntity mapToEmployeeEntity(EmployeeTo employeeTo) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeid(employeeTo.getEmployeeid());
        employeeEntity.setFirstname(employeeTo.getFirstname());
        employeeEntity.setLastname(employeeTo.getLastname());
        employeeEntity.setAge(employeeTo.getAge());
        employeeEntity.setSalary(employeeTo.getSalary());
        employeeEntity.setEmail(employeeTo.getEmail());
        employeeEntity.setCompanyid(employeeTo.getCompanyid());
        return employeeEntity;
    }
}
