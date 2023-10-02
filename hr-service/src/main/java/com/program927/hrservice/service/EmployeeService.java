package com.program927.hrservice.service;

import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;
import com.program927.hrservice.model.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer employeeId);

    MessageResponse createEmployee(EmployeeRequest employeeRequest);

    MessageResponse updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);

    MessageResponse deleteEmployee(Integer employeeId);
}
