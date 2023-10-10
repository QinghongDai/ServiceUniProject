package com.program927.facilityservice.controller;

import com.program927.facilityservice.model.common.MessageResponse;
import com.program927.facilityservice.model.eventLog.EventLog;
import com.program927.facilityservice.model.facility.Facility;
import com.program927.facilityservice.service.FacilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.program927.facilityservice.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/facility")
public class FacilityController {
    private static final Logger log = LoggerFactory.getLogger(FacilityController.class);
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Facility>> getAllFacilities () {
        log.info("start FacilityController getAll");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<Facility> facilities = null;
        try {
            facilities = facilityService.getAllFacilities();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacilityController getAll");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facilityService")
                    .serviceFunction("getAll")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<Facility> getFacilityById (@PathVariable("id") Integer id) {
        log.info("start FacilityController query");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        Facility facility = null;
        try {
            facility = facilityService.getFacilityById(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacilityController query");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facilityService")
                    .serviceFunction("getById")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(facility, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addContract(@RequestBody Facility facility) {
        log.info("start FacilityController add");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facilityService.createFacility(facility);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacilityController add");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facilityService")
                    .serviceFunction("add")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateFacility( @PathVariable Integer id, @RequestBody Facility facility) {
        log.info("start FacilityController update");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facilityService.updateFacility(id, facility);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacilityController update");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facilityService")
                    .serviceFunction("update")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteFacility(@PathVariable("id") Integer id) {
        log.info("start FacilityController delete");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facilityService.deleteFacility(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacilityController delete");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facilityService")
                    .serviceFunction("delete")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
