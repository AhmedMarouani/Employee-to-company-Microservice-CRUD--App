package com.example.demo.adapter;

import com.example.demo.adapter.to.CompanyTo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "companyClient", url = "localhost:8082/api")
public interface CompanyClient {
    @RequestMapping(method = RequestMethod.GET , value = "/v1/companies/{companyId}", produces = "application/json")
    CompanyTo getCompanyById(@PathVariable("companyId") long companyid);
}
