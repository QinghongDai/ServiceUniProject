package com.program927.facilityservice.controller;

import com.program927.facilityservice.model.common.MessageResponse;
import com.program927.facilityservice.model.eventLog.EventLog;
import com.program927.facilityservice.service.FacAppointmentService;
import com.program927.facilityservice.model.facAppointment.FacAppointment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.program927.facilityservice.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/facAppointment")
public class FacAppointmentController {
    private static final Logger log = LoggerFactory.getLogger(FacAppointmentController.class);
    @Autowired
    private FacAppointmentService facAppointmentService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<FacAppointment>> getAllFacAppointment () {
        log.info("start FacAppointmentController getAll");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<FacAppointment> facAppointments = null;
        try {
            facAppointments = facAppointmentService.getAllFacAppointment();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacAppointmentController getAll");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facAppointmentService")
                    .serviceFunction("getAll")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(facAppointments, HttpStatus.OK);
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<FacAppointment> getFacAppointmentById (@PathVariable("id") Integer id) {
        log.info("start FacAppointmentController query");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        FacAppointment facAppointment = null;
        try {
            facAppointment = facAppointmentService.getFacAppointmentById(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacAppointmentController query");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facAppointmentService")
                    .serviceFunction("getById")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(facAppointment, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addFacAppointment(@RequestBody FacAppointment facAppointment) {
        log.info("start FacAppointmentController add");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facAppointmentService.createFacAppointment(facAppointment);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacAppointmentController add");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facAppointmentService")
                    .serviceFunction("add")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateFacAppointment( @PathVariable Integer id, @RequestBody FacAppointment facAppointment) {
        log.info("start FacAppointmentController update");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facAppointmentService.updateFacAppointment(id, facAppointment);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacAppointmentController update");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facAppointmentService")
                    .serviceFunction("update")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteFacAppointment(@PathVariable("id") Integer id) {
        log.info("start FacAppointmentController delete");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facAppointmentService.deleteFacAppointment(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacAppointmentController delete");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facAppointmentService")
                    .serviceFunction("delete")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
