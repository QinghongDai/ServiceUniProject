package com.program927.hrservice.service;

import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;
import com.program927.hrservice.model.MessageResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface EmployeeService {
    MessageResponse createEmployee(EmployeeRequest employeeRequest);

    Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);

    void deleteEmployee(Integer employeeId);

    Employee getASingleEmployee(Integer employeeId);

    List<Employee> getAllEmployee();
}
