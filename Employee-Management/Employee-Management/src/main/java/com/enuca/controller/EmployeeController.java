package com.enuca.controller;

import com.enuca.dto.employee.RegisterEmployeeReqDTO;
import com.enuca.dto.employee.SimpleEmployeeResDTO;
import com.enuca.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public SimpleEmployeeResDTO registerEmployee(@RequestBody RegisterEmployeeReqDTO registerEmployeeReqDTO) throws Exception {
        return employeeService.createEmployee(registerEmployeeReqDTO);

    }
}
