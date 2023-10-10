package com.program927.examservice.controller;

import com.program927.examservice.model.eventLog.EventLog;
import com.program927.examservice.model.examAnalysis.ExamAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.program927.examservice.service.ExamAnalysisService;
import com.program927.examservice.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/examAnalysis")
public class ExamAnalysisController {
    private static final Logger log = LoggerFactory.getLogger(ExamAnalysisController.class);
    @Autowired
    private ExamAnalysisService examAnalysisService;
    @Autowired
    private LogService logService;

    @GetMapping("/getTopPopular")
    public ResponseEntity<List<ExamAnalysis>> getTopPopularExams () {
        log.info("start ExamAnalysisController getTopPopular");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<ExamAnalysis> top10Pop = null;
        try {
            top10Pop = examAnalysisService.getTopPopularExams();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamAnalysisController getTopPopular");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examAnalysisService")
                    .serviceFunction("getTopPopular")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(top10Pop, HttpStatus.OK);
    }
    @GetMapping("/getTopFailRates")
    public ResponseEntity<List<ExamAnalysis>> getTopFailRatesExams () {
        log.info("start ExamAnalysisController getTopFailRates");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<ExamAnalysis> top10Rates = null;
        try {
            top10Rates = examAnalysisService.getTopFailRatesExams();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamAnalysisController getTopFailRates");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examAnalysisService")
                    .serviceFunction("getTopFailRates")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(top10Rates, HttpStatus.OK);
    }
}
