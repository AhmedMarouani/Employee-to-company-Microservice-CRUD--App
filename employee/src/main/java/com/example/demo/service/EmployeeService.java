package com.example.demo.service;

import com.example.demo.adapter.to.CompanyTo;
import com.example.demo.controller.to.EmployeeTo;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.Dto.SimpleEmployeeTo;

import java.util.List;

public interface EmployeeService {

    List<SimpleEmployeeTo> retrieveAllEmployee();

    EmployeeTo addEmployee(EmployeeTo employeeTo, String companyName);

    void deleteEmployee(long id);

    EmployeeTo updateEmployee(EmployeeEntity e, Long id);

    EmployeeTo retreiveEmployee(Long id);

    CompanyTo getCompanyById(long id);
    void verifyExistenceById(long id);
    boolean isEmailExisting(String email);
}
