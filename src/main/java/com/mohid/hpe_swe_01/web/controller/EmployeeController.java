package com.mohid.hpe_swe_01.web.controller;

import com.mohid.hpe_swe_01.entity.Employee;
import com.mohid.hpe_swe_01.entity.Employees;
import com.mohid.hpe_swe_01.service.EmployeeManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    @GetMapping("/employees")
    public Employees getAllEmployees() {
        return EmployeeManager.getEmployees();
    }

    @PostMapping("/employees")
    public Map<String, String> addEmployee(@RequestBody Employee employee) {

        Map<String, String> response = new HashMap<>();

        if (employee.getEmployee_id() == null || employee.getEmployee_id().isEmpty()
                || employee.getFirst_name() == null || employee.getFirst_name().isEmpty()
                || employee.getLast_name() == null || employee.getLast_name().isEmpty()
                || employee.getEmail() == null || employee.getEmail().isEmpty()
                || employee.getTitle() == null || employee.getTitle().isEmpty()) {

            response.put("message", "Employee not added. Some of the required fields are missing.");
            return response;
        }

        EmployeeManager.addEmployee(employee);

        response.put("message", "Employee added successfully.");
        return response;
    }
}