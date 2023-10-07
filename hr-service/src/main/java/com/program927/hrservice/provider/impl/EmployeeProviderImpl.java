package com.program927.hrservice.provider.impl;

import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;
import com.program927.hrservice.model.MessageResponse;
import com.program927.hrservice.provider.EmployeeProvider;
import com.program927.hrservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service(version = "1.0.0")
public class EmployeeProviderImpl implements EmployeeProvider {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        return employeeService.createEmployee(employeeRequest);
    }

    @Override
    public MessageResponse updateEmployee(Integer employeeId, EmployeeRequest employeeRequest) {
        return employeeService.updateEmployee(employeeId, employeeRequest);
    }

    @Override
    public MessageResponse deleteEmployee(Integer employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }
}
