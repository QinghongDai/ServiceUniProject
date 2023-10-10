package controller;

import model.common.MessageResponse;
import model.eventLog.EventLog;
import model.facility.Facility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.FacilityService;
import service.LogService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private FacilityService facilityService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Facility>> getAllFacilities () {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<Facility> facilities = null;
        try {
            facilities = facilityService.getAllFacilities();
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        Facility facility = null;
        try {
            facility = facilityService.getFacilityById(id);
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facilityService.createFacility(facility);
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facilityService.updateFacility(id, facility);
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = facilityService.deleteFacility(id);
        } catch (Exception e) {
            status = "fail";
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
