package com.program927.examservice.controller;

import com.program927.examservice.model.eventLog.EventLog;
import com.program927.examservice.model.examAnalysis.ExamAnalysis;
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
    @Autowired
    private ExamAnalysisService examAnalysisService;
    @Autowired
    private LogService logService;

    @GetMapping("/getTopPopular")
    public ResponseEntity<List<ExamAnalysis>> getTopPopularExams () {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<ExamAnalysis> top10Pop = null;
        try {
            top10Pop = examAnalysisService.getTopPopularExams();
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<ExamAnalysis> top10Rates = null;
        try {
            top10Rates = examAnalysisService.getTopFailRatesExams();
        } catch (Exception e) {
            status = "fail";
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
