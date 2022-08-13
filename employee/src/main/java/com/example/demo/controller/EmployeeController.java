package com.example.demo.controller;

import com.example.demo.adapter.to.CompanyTo;
import com.example.demo.controller.to.EmployeeTo;
import com.example.demo.model.EmployeeEntity;
import com.example.demo.service.Dto.SimpleEmployeeTo;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/Employee")//fil controller lkol yraj3ou To?????
//we only use employeeTo in the controller to avoid messing up the database when using the Employee Entity

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    @ResponseBody
    public List<SimpleEmployeeTo> retrieveAllEmployee() {
        List<SimpleEmployeeTo> employeeToWithoutCompanies = employeeService.retrieveAllEmployee();
        return employeeToWithoutCompanies;
    }

    @GetMapping("/{employeeid}")
    @ResponseBody
    public EmployeeTo retreiveemployee(@PathVariable("employeeid")Long employeeid) {
        EmployeeTo employee = employeeService.retreiveEmployee(employeeid);
        return employee;
    }

    @GetMapping("/email/{email}")
    public boolean isEmailExisting(@PathVariable String email){
        return employeeService.isEmailExisting(email);
    }

    @PostMapping("/")
    @ResponseBody
    public EmployeeTo addEmployee(@RequestBody EmployeeTo e, String n)
    {
        EmployeeTo employeeTo = employeeService.addEmployee(e, n);
        return employeeTo;
    }

    @DeleteMapping("/{employeeid}")
    @ResponseBody
    public void deleteEmployee(@PathVariable("employeeid") Long employeeid) {
        employeeService.deleteEmployee(employeeid);
    }

    @PutMapping("/{employeeid}")
    @ResponseBody
    public EmployeeTo updateEmployee(@PathVariable("employeeid") Long employeeid, @RequestBody EmployeeEntity e) {
        EmployeeTo employeeTo = employeeService.updateEmployee(e, employeeid);
        return employeeTo;
    }

    @GetMapping("/retrieveCompany/{companyId}")
    @ResponseBody
    public CompanyTo getCompanyById (@PathVariable("companyId")long companyId) {
        CompanyTo companies = employeeService.getCompanyById(companyId);
        return companies;
    }


}
