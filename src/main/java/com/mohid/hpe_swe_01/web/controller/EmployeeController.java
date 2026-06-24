package com.mohid.hpe_swe_01.web.controller;

import com.mohid.hpe_swe_01.entity.Employee;
import com.mohid.hpe_swe_01.entity.Employees;
import com.mohid.hpe_swe_01.service.EmployeeManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

        String message = EmployeeManager.addEmployee(employee);

        response.put("message", message);
        return response;
    }

    @PutMapping("/employees/{employee_id}")
    public Map<String, String> updateEmployee(@PathVariable String employee_id, @RequestBody Employee employee) {
        Map<String, String> response = new HashMap<>();

        String message = EmployeeManager.updateEmployee(employee_id, employee);

        response.put("message", message);
        return response;
    }

    @DeleteMapping("/employees/{employee_id}")
    public Map<String, String> deleteEmployee(@PathVariable String employee_id) {
        Map<String, String> response = new HashMap<>();

        String message = EmployeeManager.deleteEmployee(employee_id);

        response.put("message", message);
        return response;
    }
}