package com.program927.facilityservice.controller;

import com.program927.facilityservice.service.FacAnalysisService;
import com.program927.facilityservice.model.eventLog.EventLog;
import com.program927.facilityservice.model.facAnalysis.FacAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.program927.facilityservice.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/facAnalysis")
public class FacAnalysisController {
    private static final Logger log = LoggerFactory.getLogger(FacAnalysisController.class);
    @Autowired
    private FacAnalysisService facAnalysisService;
    @Autowired
    private LogService logService;

    @GetMapping("/getTopPopular")
    public ResponseEntity<List<FacAnalysis>> getTopPopularFacilities () {
        log.info("start FacAnalysisController getTopPopular");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<FacAnalysis> top10Pop = null;
        try {
            top10Pop = facAnalysisService.getTopPopularFacilities();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacAnalysisController getTopPopular");
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
        log.info("start FacAnalysisController getTopRates");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<FacAnalysis> top10Rates = null;
        try {
            top10Rates = facAnalysisService.getTopRatesFacilities();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in FacAnalysisController getTopRates");
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
