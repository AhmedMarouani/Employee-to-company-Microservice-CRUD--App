package com.example.demo.mapper;

import com.example.demo.controller.To.CompanyTo;
import com.example.demo.model.CompanyEntity;

public class CompanyToMapper {
    public static CompanyTo maptocompanyTo (CompanyEntity companyEntity){
        CompanyTo companyTo = new CompanyTo();
        companyTo.setName(companyEntity.getName());
        companyTo.setDomaine(companyEntity.getDomaine());
        companyTo.setSize(companyEntity.getSize());
        companyTo.setEmployeeid(companyEntity.getEmployeeid());
        return companyTo ;
    }

    public static CompanyEntity maptocompanyEntity (CompanyTo companyTo){
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName(companyTo.getName());
        companyEntity.setDomaine(companyTo.getDomaine());
        companyEntity.setSize(companyTo.getSize());
        companyEntity.setEmployeeid(companyTo.getEmployeeid());
        return companyEntity ;
    }
}
