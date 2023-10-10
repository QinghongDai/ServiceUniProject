package com.program927.examservice.controller;

import com.program927.examservice.model.common.MessageResponse;
import com.program927.examservice.model.eventLog.EventLog;
import com.program927.examservice.model.exam.Exam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.program927.examservice.service.ExamService;
import com.program927.examservice.service.LogService;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private static final Logger log = LoggerFactory.getLogger(ExamController.class);

    @Autowired
    private ExamService examService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<Exam>> getAllExams () {

        log.info("start ExamController getAll");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<Exam> exams = null;
        try {
            exams = examService.getAllExams();
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamController getAll");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examService")
                    .serviceFunction("getAll")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }
    @GetMapping("/query/{id}")
    public ResponseEntity<Exam> getExamById (@PathVariable("id") Integer id) {
        log.info("start ExamController query");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        Exam exam = null;
        try {
            exam = examService.getExamById(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamController query");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examService")
                    .serviceFunction("getById")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(exam, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addExam(@RequestBody Exam exam) {
        log.info("start ExamController add");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examService.createExam(exam);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamController add");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examService")
                    .serviceFunction("add")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<MessageResponse> updateExam( @PathVariable Integer id, @RequestBody Exam exam) {
        log.info("start ExamController update");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examService.updateExam(id, exam);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamController update");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examService")
                    .serviceFunction("update")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageResponse> deleteExam(@PathVariable("id") Integer id) {
        log.info("start ExamController delete");
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examService.deleteExam(id);
        } catch (Exception e) {
            status = "fail";
            log.error("Error occurred in ExamController delete");
        } finally {
            logService.addLog(EventLog.builder()
                    .serviceProvider("examServiceProvider")
                    .serviceName("examService")
                    .serviceFunction("delete")
                    .status(status)
                    .startTime(startTime)
                    .endTime(System.currentTimeMillis())
                    .build());
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
