package com.program927.hrservice.service.impl;

import com.program927.hrservice.dao.EmployeeDao;
import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;
import com.program927.hrservice.model.MessageResponse;
import com.program927.hrservice.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastname(employeeRequest.getLastname());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setSalary(employeeRequest.getSalary());
        newEmployee.setDepartment(employeeRequest.getDepartment());
        employeeDao.save(newEmployee);
        return MessageResponse.builder().message("Employee created successfully").build();
    }

    @Override
    public Optional<Employee> updateEmployee(Integer employeeId, EmployeeRequest employeeRequest){
        Optional<Employee> employee = employeeDao.findById(employeeId);
        if (employee.isEmpty()){
            return null;
        }
        else
            employee.get().setFirstName(employeeRequest.getFirstName());
            employee.get().setLastname(employeeRequest.getLastname());
            employee.get().setPhoneNumber(employeeRequest.getPhoneNumber());
            employee.get().setEmail(employeeRequest.getEmail());
            employee.get().setSalary(employeeRequest.getSalary());
            employee.get().setDepartment(employeeRequest.getDepartment());
            employeeDao.save(employee.get());
        return employee;
    }

    @Override
    public Employee getASingleEmployee(Integer employeeId) {
        return employeeDao.findById(employeeId).orElseThrow(() -> null);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }
    @Override
    public void deleteEmployee(Integer employeeId) {
        employeeDao.deleteById(employeeId);
    }
}
