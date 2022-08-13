package com.example.demo.service;

import com.example.demo.controller.To.CompanyTo;
import com.example.demo.mapper.CompanyToMapper;
import com.example.demo.model.CompanyEntity;
import com.example.demo.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.mapper.CompanyToMapper.maptocompanyTo;

@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<CompanyTo> retrieveAllCompanies() {
        return companyRepository.findAll().stream().map(CompanyToMapper::maptocompanyTo).collect(Collectors.toList());
    }

    @Override
    public CompanyTo addCompany(CompanyTo c) {
        log.info("saving client", c);
        return CompanyToMapper.maptocompanyTo(companyRepository.save(
                CompanyToMapper.maptocompanyEntity(c)));
    }

    @Override
    public void deleteCompany(Long id) {
        log.info("Deleting company by id: {}", id);
        companyRepository.deleteById(id);
    }

    @Override
    public CompanyTo updateCompany(CompanyTo c, Long id) {
        log.info("Company updated", c);

        CompanyEntity updatedcompany = companyRepository.findById(id).get();

        updatedcompany.setName(c.getName());
        updatedcompany.setSize(c.getSize());
        updatedcompany.setDomaine(c.getDomaine());
        updatedcompany.setEmployeeid(c.getEmployeeid());
        return CompanyToMapper.maptocompanyTo(companyRepository.save(updatedcompany));
    }


    @Override
    public CompanyTo retreiveCompany(Long id) {
        log.info("fetching Company by id: {}", id);
        CompanyEntity companyEntity = companyRepository.findById(id).get();
        CompanyTo companyTo = maptocompanyTo(companyEntity);
        return companyTo;
    }



}
