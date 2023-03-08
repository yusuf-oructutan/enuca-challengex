package com.enuca.controller;

import com.enuca.dto.company.RegisterCompanyReqDTO;
import com.enuca.dto.company.SimpleCompanyResDTO;
import com.enuca.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// POST localhost:8080/companies/1
@RestController
@RequestMapping("companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    public SimpleCompanyResDTO registerCompany(@RequestBody RegisterCompanyReqDTO registerCompanyReqDTO) {
        SimpleCompanyResDTO company = companyService.createCompany(registerCompanyReqDTO);
        return company;
    }

    @GetMapping("{companyId}")
    public SimpleCompanyResDTO getCompanyById(@PathVariable("companyId") Long companyId) {
        SimpleCompanyResDTO company = companyService.findById(companyId);
        return company;
    }

    @GetMapping
    public List<SimpleCompanyResDTO> getAllCompanies() {
        List<SimpleCompanyResDTO> companyList = companyService.findAll();
        return companyList;
    }
}
