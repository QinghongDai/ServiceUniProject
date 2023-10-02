package com.program927.hrservice.dao;

import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;

import java.util.List;
import java.util.Optional;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(Integer employeeId);

    int save(Employee newEmployee);

    int update(Integer employeeId, EmployeeRequest employeeRequest);

    int deleteById(Integer employeeId);
}
