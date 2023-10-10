package com.program927.hrservice.controller;

import com.program927.hrservice.model.contract.Contract;
import com.program927.hrservice.model.common.MessageResponse;
import com.program927.hrservice.model.contract.ContractRequest;
import com.program927.hrservice.model.eventLog.EventLog;
import com.program927.hrservice.service.ContractService;
import com.program927.hrservice.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contract")
public class ContractController {
    private static final Logger log = LoggerFactory.getLogger(ContractController.class);
    @Autowired
    private ContractService contractService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Contract>> getAllContracts () {
        log.error("start ContractController getAll");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<Contract> contracts = null;
        try {
            contracts = contractService.getAllContract();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ContractController getAll");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("contractService")
                    .serviceFunction("getAll")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(contracts, HttpStatus.OK);
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<Contract> getContractById (@PathVariable("id") Integer id) {
        log.error("start ContractController query");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        Contract contract = null;
        try {
            contract = contractService.getContractById(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ContractController query");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("contractService")
                    .serviceFunction("getById")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addContract(@RequestBody Contract contract) {
        log.error("start ContractController add");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = contractService.createContract(contract);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ContractController add");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("contractService")
                    .serviceFunction("add")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateContract( @PathVariable Integer id, @RequestBody ContractRequest contract) {
        log.info("start ContractController update");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = contractService.updateContract(id, contract);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ContractController update");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("contractService")
                    .serviceFunction("update")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteContract(@PathVariable("id") Integer id) {
        log.info("start ContractController delete");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = contractService.deleteContract(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ContractController delete");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("hrServiceProvider")
                    .serviceName("contractService")
                    .serviceFunction("delete")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
