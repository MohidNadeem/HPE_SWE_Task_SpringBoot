# Basic Employee Management REST API - Spring Boot
## For HPE Forage Job Simulation

A simple RESTful web service built using Java Spring Boot for managing employee data.
This project was developed as part of a HPE Forage Software Engineering job simulation task.

## Features

* Get all employees
* Add new employees
* Update existing employees
* Delete employees
* Store employee data in a local JSON file
* Input validation and error handling
* Duplicate Employee ID checking
* Unit testing using JUnit

---

## Technologies Used

* Java 17
* Spring Boot
* Maven
* Jackson JSON Library
* JUnit 5
* NetBeans IDE

---

## API Endpoints

### Get All Employees

```http
GET /employees
```

### Add Employee

```http
POST /employees
```

Example Request Body:

```json
{
  "employee_id": "E004",
  "first_name": "Mohid",
  "last_name": "Nadeem",
  "email": "mohid.n@example.com",
  "title": "Junior Project Manager"
}
```

---

### Update Employee

```http
PUT /employees/{employee_id}
```

---

### Delete Employee

```http
DELETE /employees/{employee_id}
```

---

## JSON File Storage

Employee data is stored in:

```text
employees.json
```

The file is automatically created and updated whenever employees are added, updated, or deleted.

---

## Unit Testing

JUnit tests were implemented for:

* Getting all employees
* Adding employee successfully
* Adding employee with missing fields
* Adding duplicate employee
* Updating employee
* Deleting employee

Run tests using:

```bash
mvn test
```

---

## Project Structure

```text
src
 ├── main
 │    └── java
 │         └── com.mohid.hpe_swe_01
 │              ├── entity
 │              ├── service
 │              └── web.controller
 │
 └── test
      └── java
           └── EmployeeControllerTest.java
```

---

## Author

Mohid Nadeem
