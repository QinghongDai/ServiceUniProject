package com.program927.facilityservice.controller;

import com.program927.facilityservice.service.FacAnalysisService;
import com.program927.facilityservice.model.eventLog.EventLog;
import com.program927.facilityservice.model.facAnalysis.FacAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.program927.facilityservice.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/facAnalysis")
public class FacAnalysisController {
    @Autowired
    private FacAnalysisService facAnalysisService;
    @Autowired
    private LogService logService;

    @GetMapping("/getTopPopular")
    public ResponseEntity<List<FacAnalysis>> getTopPopularFacilities () {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<FacAnalysis> top10Pop = null;
        try {
            top10Pop = facAnalysisService.getTopPopularFacilities();
        } catch (Exception e) {
            status = "fail";
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facAnalysisService")
                    .serviceFunction("getTopPopular")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(top10Pop, HttpStatus.OK);
    }
    @GetMapping("/getTopRates")
    public ResponseEntity<List<FacAnalysis>> getTopRatesFacilities () {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<FacAnalysis> top10Rates = null;
        try {
            top10Rates = facAnalysisService.getTopRatesFacilities();
        } catch (Exception e) {
            status = "fail";
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("facilityServiceProvider")
                    .serviceName("facAnalysisService")
                    .serviceFunction("getTopRates")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(top10Rates, HttpStatus.OK);
    }
}
