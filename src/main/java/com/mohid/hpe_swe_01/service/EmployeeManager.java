package com.mohid.hpe_swe_01.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mohid.hpe_swe_01.entity.Employee;
import com.mohid.hpe_swe_01.entity.Employees;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {

    private static final String FILE_PATH = "employees.json";
    private static final ObjectMapper objectMapper = new ObjectMapper();

    // getting all employees from json file
    public static Employees getEmployees() {

        try {

            File file = new File(FILE_PATH);

            if (file.exists()) {
                // Reading employees from json file
                return objectMapper.readValue(file, Employees.class);
            }

            // Creating default employee list
            Employees employees = createDefaultEmployees();

            // Saving default employees to json file
            saveEmployees(employees);

            return employees;

        } catch (Exception e) {

            e.printStackTrace();

            // Returning empty employee list if error occurs
            Employees emptyEmployees = new Employees();
            emptyEmployees.setEmployees(new ArrayList<>());

            return emptyEmployees;
        }
    }

    // Adding new employee
    public static String addEmployee(Employee employee) {

        // Getting existing employees
        Employees employees = getEmployees();

        // Checking if employee data is invalid
        if (isInvalidEmployee(employee)) {
            return "Employee not added. Some of the required fields are missing.";
        }

        // Checking if employee id already exists
        if (isDuplicateEmployeeId(employee.getEmployee_id())) {
            return "Employee not added. Employee ID already exists.";
        }

        // Adding employee to list
        employees.getEmployees().add(employee);
        saveEmployees(employees);

        return "Employee added successfully.";
    }

    // Updating existing employee
    public static String updateEmployee(String employeeId, Employee updatedEmployee) {

        // Getting all employees
        Employees employees = getEmployees();

        // Checking if employee id is empty
        if (isBlank(employeeId)) {
            return "Employee not updated. Employee ID is required.";
        }

        // Checking if updated employee data is invalid
        if (isInvalidEmployee(updatedEmployee)) {
            return "Employee not updated. Some of the required fields are missing.";
        }

        for (Employee emp : employees.getEmployees()) {

            if (emp.getEmployee_id().equals(employeeId)) {

                // Checking if url id and body id are same
                if (!updatedEmployee.getEmployee_id().equals(employeeId)) {
                    return "Employee not updated. Employee ID in URL and body must match.";
                }

                // Updating employee data
                emp.setFirst_name(updatedEmployee.getFirst_name());
                emp.setLast_name(updatedEmployee.getLast_name());
                emp.setEmail(updatedEmployee.getEmail());
                emp.setTitle(updatedEmployee.getTitle());

                // Saving updated employees
                saveEmployees(employees);

                return "Employee updated successfully.";
            }
        }

        return "Employee not updated. Employee ID not found.";
    }

    // Deleting an employee
    public static String deleteEmployee(String employeeId) {

        Employees employees = getEmployees();

        // Checking if employee id is empty
        if (isBlank(employeeId)) {
            return "Employee not deleted. Employee ID is required.";
        }

        for (Employee emp : employees.getEmployees()) {

            if (emp.getEmployee_id().equals(employeeId)) {

                // Removing employee from list
                employees.getEmployees().remove(emp);

                // Saving updated employee list
                saveEmployees(employees);

                return "Employee deleted successfully.";
            }
        }

        return "Employee not deleted. Employee ID not found.";
    }

    // Checking duplicate employee id
    private static boolean isDuplicateEmployeeId(String employeeId) {

        Employees employees = getEmployees();

        for (Employee emp : employees.getEmployees()) {

            if (emp.getEmployee_id().equals(employeeId)) {
                return true;
            }
        }

        return false;
    }

    // Validating employee object
    private static boolean isInvalidEmployee(Employee employee) {

        return employee == null
                || isBlank(employee.getEmployee_id())
                || isBlank(employee.getFirst_name())
                || isBlank(employee.getLast_name())
                || isBlank(employee.getEmail())
                || isBlank(employee.getTitle())
                || !employee.getEmail().contains("@");
    }

    // Checking if string is empty
    private static boolean isBlank(String value) {

        return value == null || value.trim().isEmpty();
    }

    // Creating default employees
    private static Employees createDefaultEmployees() {

        List<Employee> employeeList = new ArrayList<>();

        // Adding default employees
        employeeList.add(new Employee("E001", "Dhara", "Kumari", "dkr.mtr@example.com", "Software Engineer"));
        employeeList.add(new Employee("E002", "Ayesha", "Malik", "ayesha.malik@example.com", "QA Engineer"));
        employeeList.add(new Employee("E003", "Ali", "Jodat", "ali.jodat@example.com", "Software Engineer"));
        employeeList.add(new Employee("E004", "Mohid", "Nadeem", "mohid.nadeem@example.com", "Project Manager"));

        Employees employees = new Employees();

        employees.setEmployees(employeeList);

        return employees;
    }

    // Saving employees to json file
    private static void saveEmployees(Employees employees) {

        try {

            objectMapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(FILE_PATH), employees);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}