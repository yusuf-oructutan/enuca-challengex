package com.enuca.service.impl;

import com.enuca.dto.company.RegisterCompanyReqDTO;
import com.enuca.dto.company.SimpleCompanyResDTO;
import com.enuca.entity.CompanyEntity;
import com.enuca.repository.CompanyRepository;
import com.enuca.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public SimpleCompanyResDTO createCompany(RegisterCompanyReqDTO registerCompanyReqDTO) {

        CompanyEntity newCompany = new CompanyEntity();
        newCompany.setName(registerCompanyReqDTO.getName());
        newCompany.setDescription(registerCompanyReqDTO.getDescription());

        CompanyEntity savedCompany = companyRepository.save(newCompany);

        SimpleCompanyResDTO simpleCompanyResDTO = new SimpleCompanyResDTO();

        simpleCompanyResDTO.setCompanyId(savedCompany.getCompanyId());
        simpleCompanyResDTO.setName(savedCompany.getName());
        simpleCompanyResDTO.setDescription(savedCompany.getDescription());

        return simpleCompanyResDTO;
    }

    @Override
    public SimpleCompanyResDTO findById(Long companyId) {

        CompanyEntity companyEntity = companyRepository.findById(companyId).get();

        SimpleCompanyResDTO simpleCompanyResDTO = new SimpleCompanyResDTO();

        simpleCompanyResDTO.setCompanyId(companyEntity.getCompanyId());
        simpleCompanyResDTO.setName(companyEntity.getName());
        simpleCompanyResDTO.setDescription(companyEntity.getDescription());

        return simpleCompanyResDTO;
    }

    @Override
    public List<SimpleCompanyResDTO> findAll() {

        List<CompanyEntity> companyEntityList = companyRepository.findAll();

        List<SimpleCompanyResDTO> simpleCompanyResDTOList = new ArrayList<>();

        for (CompanyEntity companyEntity : companyEntityList) {

            SimpleCompanyResDTO simpleCompanyResDTO = new SimpleCompanyResDTO();

            simpleCompanyResDTO.setCompanyId(companyEntity.getCompanyId());
            simpleCompanyResDTO.setName(companyEntity.getName());
            simpleCompanyResDTO.setDescription(companyEntity.getDescription());

            simpleCompanyResDTOList.add(simpleCompanyResDTO);
        }

        return simpleCompanyResDTOList;
    }
}