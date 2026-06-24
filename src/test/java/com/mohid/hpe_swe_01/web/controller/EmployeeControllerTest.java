package com.mohid.hpe_swe_01.web.controller;

import com.mohid.hpe_swe_01.entity.Employee;
import com.mohid.hpe_swe_01.entity.Employees;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeControllerTest {

    @Test
    public void testGetAllEmployees() {

        EmployeeController controller = new EmployeeController();

        // Getting all employees from the controller
        Employees employees = controller.getAllEmployees();

        assertNotNull(employees);

        // Checking if employees list is not null
        assertNotNull(employees.getEmployees());

        // Checking if employee list contains at least 4 employees
        assertTrue(employees.getEmployees().size() >= 4);
    }

    @Test
    public void testAddEmployeeSuccessfully() {

        EmployeeController controller = new EmployeeController();

        // Creating a new employee object
        Employee employee = new Employee(
                "E010",
                "Sara",
                "Khan",
                "sara.khan@example.com",
                "Business Analyst"
        );

        Map<String, String> response = controller.addEmployee(employee);

        // Checking if employee is added successfully
        assertEquals("Employee added successfully.", response.get("message"));
    }

    @Test
    public void testAddEmployeeWithMissingField() {

        EmployeeController controller = new EmployeeController();

        // Creating an employee object with missing employee id
        Employee employee = new Employee(
                "",
                "Test",
                "User",
                "test@example.com",
                "Intern"
        );

        // Trying to add invalid employee
        Map<String, String> response = controller.addEmployee(employee);

        // Checking if proper error message is returned
        assertEquals("Employee not added. Some of the required fields are missing.", response.get("message"));
    }
}