package com.program927.hrservice.service.impl;

import com.program927.hrservice.dao.EmployeeDao;
import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;
import com.program927.hrservice.model.EventLog;
import com.program927.hrservice.model.MessageResponse;
import com.program927.hrservice.service.EmployeeService;
import com.program927.hrservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private LogService logService;

    @Override
    public List<Employee> getAllEmployee() {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        try {
            return employeeDao.findAll();
        } catch (Exception e)  {
            status = "fail";
            return null;
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("employeeService")
                    .serviceFunction("getAll")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
    }
    @Override
    public Employee getEmployeeById(Integer employeeId) {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        try {
            return employeeDao.findById(employeeId);
        } catch (Exception e)  {
            status = "fail";
            return null;
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("employeeService")
                    .serviceFunction("getById")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
    }

    @Override
    public MessageResponse createEmployee(EmployeeRequest employeeRequest) {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        try {
            Employee newEmployee = new Employee();
            newEmployee.setFirstName(employeeRequest.getFirstName());
            newEmployee.setLastname(employeeRequest.getLastName());
            newEmployee.setPhoneNumber(employeeRequest.getPhoneNumber());
            newEmployee.setEmail(employeeRequest.getEmail());
            newEmployee.setSalary(employeeRequest.getSalary());
            newEmployee.setDepartment(employeeRequest.getDepartment());
            int result = employeeDao.save(newEmployee);
            if (0 == result){
                status = "fail";
                return MessageResponse.builder().message("Fail").build();
            }
            return MessageResponse.builder().message("Success").build();
        } catch (Exception e) {
            status = "fail";
            return MessageResponse.builder().message("Fail").build();
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("employeeService")
                    .serviceFunction("add")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
    }

    @Override
    public MessageResponse updateEmployee(Integer employeeId, EmployeeRequest employeeRequest){
        Long startTime = System.currentTimeMillis();
        String status = "success";
        try {
            Employee employee = employeeDao.findById(employeeId);
            if (null== employee){
                status = "fail";
                return MessageResponse.builder().message("Fail").build();
            } else {
                int result = employeeDao.update(employeeId, employeeRequest);
                if (0 == result){
                    status = "fail";
                    return MessageResponse.builder().message("Fail").build();
                }
                return MessageResponse.builder().message("Success").build();
            }
        } catch (Exception e) {
            status = "fail";
            return MessageResponse.builder().message("Fail").build();
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("employeeService")
                    .serviceFunction("update")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }

    }

    @Override
    public MessageResponse deleteEmployee(Integer employeeId) {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        try {
            int result = employeeDao.deleteById(employeeId);
            if (0 == result){
                status = "fail";
                return MessageResponse.builder().message("Fail").build();
            }
            return MessageResponse.builder().message("Success").build();
        } catch (Exception e) {
            status = "fail";
            return MessageResponse.builder().message("Fail").build();
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("employeeService")
                    .serviceFunction("delete")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
    }
}
