package com.program927.hrservice.service.impl;

import com.program927.hrservice.dao.EmployeeDao;
import com.program927.hrservice.model.employee.Employee;
import com.program927.hrservice.model.employee.EmployeeRequest;
import com.program927.hrservice.model.common.MessageResponse;
import com.program927.hrservice.service.EmployeeService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Log4j
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.findAll();
    }
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeDao.findById(employeeId);
    }

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        Employee newEmployee = new Employee();
        newEmployee.setFirstName(employeeRequest.getFirstName());
        newEmployee.setLastName(employeeRequest.getLastName());
        newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
        newEmployee.setEmail(employeeRequest.getEmail());
        newEmployee.setSalary(employeeRequest.getSalary());
        newEmployee.setDepartment(employeeRequest.getDepartment());
        int result = employeeDao.save(newEmployee);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }

    @Override
    public MessageResponse updateEmployee(Integer employeeId, EmployeeRequest employeeRequest){
        Employee employee = employeeDao.findById(employeeId);
        if (null== employee){
            return MessageResponse.builder().message("Fail").build();
        } else {
            int result = employeeDao.update(employeeId, employeeRequest);
            if (0 == result){
                return MessageResponse.builder().message("Fail").build();
            }
            return MessageResponse.builder().message("Success").build();
        }
    }

    @Override
    public MessageResponse deleteEmployee(Integer employeeId) {
        int result = employeeDao.deleteById(employeeId);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }
}
