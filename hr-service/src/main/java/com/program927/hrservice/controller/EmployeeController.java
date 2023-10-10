package com.program927.hrservice.controller;

import com.program927.hrservice.model.employee.Employee;
import com.program927.hrservice.model.employee.EmployeeRequest;
import com.program927.hrservice.model.common.MessageResponse;
import com.program927.hrservice.model.eventLog.EventLog;
import com.program927.hrservice.service.EmployeeService;
import com.program927.hrservice.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        log.info("start EmployeeController getAll");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<Employee> employees = null;
        try {
            employees = employeeService.getAllEmployee();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in EmployeeController getAll");
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
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Integer id) {
        log.info("start EmployeeController query");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        Employee employee = null;
        try {
            employee = employeeService.getEmployeeById(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in EmployeeController query");
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
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addEmployee(@RequestBody EmployeeRequest employee) {
        log.info("start EmployeeController add");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = employeeService.createEmployee(employee);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in EmployeeController add");
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
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateEmployee( @PathVariable Integer id, @RequestBody EmployeeRequest employee) {
        log.info("start EmployeeController update");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = employeeService.updateEmployee(id, employee);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in EmployeeController update");
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
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteEmployee(@PathVariable("id") Integer id) {
        log.info("start EmployeeController delete");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = employeeService.deleteEmployee(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in EmployeeController delete");
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
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
