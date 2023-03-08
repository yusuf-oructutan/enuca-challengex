package com.enuca.service;

import com.enuca.dto.company.RegisterCompanyReqDTO;
import com.enuca.dto.company.SimpleCompanyResDTO;

import java.util.List;

public interface CompanyService {

    SimpleCompanyResDTO createCompany(RegisterCompanyReqDTO registerCompanyReqDTO);

    SimpleCompanyResDTO findById(Long companyId);

    List<SimpleCompanyResDTO> findAll();
}
