package com.program927.examservice.controller;

import com.program927.examservice.model.common.MessageResponse;
import com.program927.examservice.model.eventLog.EventLog;
import com.program927.examservice.model.examParticipants.ExamParticipants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.program927.examservice.service.ExamParticipantsService;
import com.program927.examservice.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/examParticipants")
public class ExamParticipantsController {
    private static final Logger log = LoggerFactory.getLogger(ExamParticipantsController.class);
    @Autowired
    private ExamParticipantsService examParticipantsService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ExamParticipants>> getAllExamParticipants() {
        log.info("start ExamParticipantsController getAll");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<ExamParticipants> examParticipants = null;
        try {
            examParticipants = examParticipantsService.getAllExamParticipants();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamParticipantsController getAll");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examParticipantsService")
                    .serviceFunction("getAll")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(examParticipants, HttpStatus.OK);
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<ExamParticipants> getExamParticipantById (@PathVariable("id") Integer id) {
        log.info("start ExamParticipantsController query");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        ExamParticipants examParticipant = null;
        try {
            examParticipant = examParticipantsService.getExamParticipantById(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamParticipantsController query");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examParticipantsService")
                    .serviceFunction("getById")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(examParticipant, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addExamParticipant(@RequestBody ExamParticipants examParticipants) {
        log.info("start ExamParticipantsController add");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examParticipantsService.createExamParticipant(examParticipants);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamParticipantsController add");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examParticipantsService")
                    .serviceFunction("add")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateExamParticipant( @PathVariable Integer id, @RequestBody ExamParticipants examParticipants) {
        log.info("start ExamParticipantsController update");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examParticipantsService.updateExamParticipant(id, examParticipants);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamParticipantsController update");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examParticipantsService")
                    .serviceFunction("update")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteExamParticipant(@PathVariable("id") Integer id) {
        log.info("start ExamParticipantsController delete");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examParticipantsService.deleteExamParticipant(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamParticipantsController delete");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examParticipantsService")
                    .serviceFunction("delete")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
