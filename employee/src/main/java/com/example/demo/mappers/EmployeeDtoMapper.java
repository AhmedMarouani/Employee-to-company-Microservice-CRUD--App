package com.example.demo.mappers;

import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.Dto.SimpleEmployeeTo;

public class EmployeeDtoMapper {
    public static SimpleEmployeeTo mapToEmployeeDto (EmployeeEntity employeeEntity){
        SimpleEmployeeTo simpleEmployeeTo = new SimpleEmployeeTo();
        simpleEmployeeTo.setEmployeeid(employeeEntity.getEmployeeid());
        simpleEmployeeTo.setFirstname(employeeEntity.getFirstname());
        simpleEmployeeTo.setLastname(employeeEntity.getLastname());
        simpleEmployeeTo.setAge(employeeEntity.getAge());
        simpleEmployeeTo.setSalary(employeeEntity.getSalary());
        simpleEmployeeTo.setEmail(employeeEntity.getEmail());
        simpleEmployeeTo.setCompanyid(employeeEntity.getCompanyid());
        return simpleEmployeeTo;
    }

    public static EmployeeEntity mapToEmployeeEntity (SimpleEmployeeTo simpleEmployeeTo){
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setEmployeeid(simpleEmployeeTo.getEmployeeid());
        employeeEntity.setFirstname(simpleEmployeeTo.getFirstname());
        employeeEntity.setLastname(simpleEmployeeTo.getLastname());
        employeeEntity.setAge(simpleEmployeeTo.getAge());
        employeeEntity.setSalary(simpleEmployeeTo.getSalary());
        employeeEntity.setEmail(simpleEmployeeTo.getEmail());
        employeeEntity.setCompanyid(simpleEmployeeTo.getCompanyid());
        return employeeEntity ;
    }
}
