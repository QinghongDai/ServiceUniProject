package com.program927.hrservice.dao;

import com.program927.hrservice.model.employee.Employee;
import com.program927.hrservice.model.employee.EmployeeRequest;

import java.util.List;

public interface EmployeeDao {

    List<Employee> findAll();

    Employee findById(Integer employeeId);

    int save(Employee newEmployee);

    int update(Integer employeeId, EmployeeRequest employeeRequest);

    int deleteById(Integer employeeId);
}
