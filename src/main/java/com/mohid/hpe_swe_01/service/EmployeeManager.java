package com.mohid.hpe_swe_01.service;

import com.mohid.hpe_swe_01.entity.Employee;
import com.mohid.hpe_swe_01.entity.Employees;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    public static Employees getEmployees() {
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(new Employee("E001", "Dhara", "Kumari", "dkr.mtr@example.com", "Software Engineer"));
        employeeList.add(new Employee("E002", "Ayesha", "Malik", "ayesha.malik@example.com", "QA Engineer"));
        employeeList.add(new Employee("E003", "Ali", "Jodat", "ali.jodat@example.com", "Software Engineer"));
        employeeList.add(new Employee("E004", "Mohid", "Nadeem", "ayesha.malik@example.com", "Project Manager"));

        Employees employees = new Employees();
        employees.setEmployees(employeeList);

        return employees;
    }
}