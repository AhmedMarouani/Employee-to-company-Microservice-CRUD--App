package com.example.demo.service;

import com.example.demo.controller.To.CompanyTo;
import com.example.demo.model.CompanyEntity;

import java.util.List;

public interface CompanyService {

    List<CompanyTo> retrieveAllCompanies();

    CompanyTo addCompany(CompanyTo c);

    void deleteCompany(Long id);

    CompanyTo updateCompany(CompanyTo c, Long id);

    CompanyTo retreiveCompany(Long id);

}
