package com.program927.hrservice.provider;

import com.program927.hrservice.model.employee.Employee;
import com.program927.hrservice.model.employee.EmployeeRequest;
import com.program927.hrservice.model.common.MessageResponse;

import java.util.List;

public interface EmployeeProvider {
    List<Employee> getAllEmployee();

    Employee getEmployeeById(Integer employeeId);

    MessageResponse createEmployee(EmployeeRequest employeeRequest);

    MessageResponse updateEmployee(Integer employeeId, EmployeeRequest employeeRequest);

    MessageResponse deleteEmployee(Integer employeeId);
}
