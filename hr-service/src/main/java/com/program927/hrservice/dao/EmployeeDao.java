package com.program927.hrservice.dao;

import com.program927.hrservice.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {
    void save(Employee newEmployee);

    Optional<Employee> findById(Integer employeeId);

    List<Employee> findAll();

    void deleteById(Integer employeeId);
}
