package com.program927.hrservice.controller;

import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;
import com.program927.hrservice.model.MessageResponse;
import com.program927.hrservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.getAllEmployee();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Integer id) {
        Employee employee = employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest employee) {
        MessageResponse response = employeeService.createEmployee(employee);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateEmployee( @PathVariable Integer id, @RequestBody EmployeeRequest employee) {
        MessageResponse response = employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteEmployee(@PathVariable("id") Integer id) {
        MessageResponse response = employeeService.deleteEmployee(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
