package com.example.demo.controller;

import com.example.demo.controller.To.CompanyTo;
import com.example.demo.model.CompanyEntity;
import com.example.demo.service.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {
    @Autowired
    CompanyServiceImpl companyService;

    @GetMapping("/")
    @ResponseBody
    public List<CompanyTo> retrieveAllCompanies() {
        List<CompanyTo> companies = companyService.retrieveAllCompanies();
        return companies;
    }

    @GetMapping("/{idCompany}")
    @ResponseBody
    public CompanyTo retreiveCompany(@PathVariable("idCompany")Long idCompany) {
        CompanyTo companyTo = companyService.retreiveCompany(idCompany);
        return companyTo;
    }

    @PostMapping("/")
    @ResponseBody
    public CompanyTo addCompany(@RequestBody CompanyTo c)
    {
        CompanyTo companyTo = companyService.addCompany(c);
        return companyTo;
    }

    @DeleteMapping("/{idCompany}")
    @ResponseBody
    public void deleteCompany(@PathVariable("idCompany") Long idCompany) {
        companyService.deleteCompany(idCompany);
    }

    @PutMapping("/{idCompany}")
    @ResponseBody
    public CompanyTo updateCompany(@PathVariable("idCompany") Long idCompany, @RequestBody CompanyTo c) {
        CompanyTo companyTo = companyService.updateCompany(c, idCompany);
        return companyTo;
    }



}
