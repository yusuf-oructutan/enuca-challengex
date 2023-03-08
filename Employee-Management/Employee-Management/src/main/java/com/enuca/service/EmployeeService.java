package com.enuca.service;

import com.enuca.dto.employee.RegisterEmployeeReqDTO;
import com.enuca.dto.employee.SimpleEmployeeResDTO;

public interface EmployeeService {

    SimpleEmployeeResDTO createEmployee(RegisterEmployeeReqDTO registerEmployeeReqDTO) throws Exception;
}