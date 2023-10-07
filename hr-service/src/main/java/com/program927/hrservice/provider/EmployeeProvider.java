package com.program927.hrservice.provider;

import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;
import com.program927.hrservice.model.MessageResponse;

import java.util.List;

public interface EmployeeProvider {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer employeeId);

    MessageResponse createEmployee(EmployeeRequest employeeRequest);

    MessageResponse updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);

    MessageResponse deleteEmployee(Integer employeeId);
}
