package com.mohid.hpe_swe_01.web.controller;

import com.mohid.hpe_swe_01.entity.Employees;
import com.mohid.hpe_swe_01.service.EmployeeManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public Employees getAllEmployees() {
        return EmployeeManager.getEmployees();
    }
}