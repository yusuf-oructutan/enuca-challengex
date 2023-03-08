package com.enuca.service.impl;


import com.enuca.dto.employee.RegisterEmployeeReqDTO;
import com.enuca.dto.employee.SimpleEmployeeResDTO;
import com.enuca.entity.CompanyEntity;
import com.enuca.entity.EmployeeEntity;
import com.enuca.repository.CompanyRepository;
import com.enuca.repository.EmployeeRepository;
import com.enuca.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private CompanyRepository companyRepository;


    @Override
    public SimpleEmployeeResDTO createEmployee(RegisterEmployeeReqDTO registerEmployeeReqDTO) throws Exception {

        EmployeeEntity newEmployee = new EmployeeEntity();
        newEmployee.setFirstName(registerEmployeeReqDTO.getFirstName());
        newEmployee.setLastName(registerEmployeeReqDTO.getLastName());
        newEmployee.setAge(registerEmployeeReqDTO.getAge());
        newEmployee.setEmail(registerEmployeeReqDTO.getEmail());
        newEmployee.setSalary(registerEmployeeReqDTO.getSalary());

        CompanyEntity companyEntity = companyRepository.findById(registerEmployeeReqDTO.getCompanyId()).orElseThrow(() -> {
            return new Exception("Company not found! companyId : " + registerEmployeeReqDTO.getCompanyId());
        });
        newEmployee.setCompany(companyEntity);

        EmployeeEntity savedEmployee = employeeRepository.save(newEmployee);

        SimpleEmployeeResDTO simpleEmployeeResDTO = new SimpleEmployeeResDTO();
        simpleEmployeeResDTO.setEmployeeId(savedEmployee.getEmployeeId());
        simpleEmployeeResDTO.setFirstName(savedEmployee.getFirstName());
        simpleEmployeeResDTO.setLastName(savedEmployee.getLastName());
        simpleEmployeeResDTO.setAge(savedEmployee.getAge());
        simpleEmployeeResDTO.setEmail(savedEmployee.getEmail());
        simpleEmployeeResDTO.setSalary(savedEmployee.getSalary());
        simpleEmployeeResDTO.setCompanyId(savedEmployee.getCompany().getCompanyId());

        return simpleEmployeeResDTO;
    }
}