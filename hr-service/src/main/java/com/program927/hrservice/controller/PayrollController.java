package com.program927.hrservice.controller;

import com.program927.hrservice.model.common.MessageResponse;
import com.program927.hrservice.model.eventLog.EventLog;
import com.program927.hrservice.model.payroll.Payroll;
import com.program927.hrservice.service.LogService;
import com.program927.hrservice.service.PayrollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payroll")
public class PayrollController {
    private static final Logger log = LoggerFactory.getLogger(PayrollController.class);
    @Autowired
    private PayrollService payrollService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Payroll>> getAllPayroll () {
        log.error("start PayrollController getAll");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<Payroll> payrolls = null;
        try {
            payrolls = payrollService.getAllPayroll();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in PayrollController getAll");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("payrollService")
                    .serviceFunction("getAll")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(payrolls, HttpStatus.OK);
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<Payroll> getPayrollById (@PathVariable("id") Integer id) {
        log.error("start PayrollController query");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        Payroll payroll = null;
        try {
            payroll = payrollService.getPayrollById(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in PayrollController query");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("payrollService")
                    .serviceFunction("getById")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(payroll, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addPayroll(@RequestBody Payroll payroll) {
        log.error("start PayrollController add");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = payrollService.createPayroll(payroll);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in PayrollController add");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("payrollService")
                    .serviceFunction("add")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/batchAdd")
    public ResponseEntity<MessageResponse> batchAdd(@RequestBody List<Payroll> payrolls) {
        log.error("start PayrollController batchAdd");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = payrollService.batchAdd(payrolls);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in PayrollController batchAdd");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("payrollService")
                    .serviceFunction("batchAdd")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deletePayroll(@PathVariable("id") Integer id) {
        log.error("start PayrollController delete");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = payrollService.deletePayroll(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in PayrollController delete");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("payrollService")
                    .serviceFunction("delete")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
