package controller;

import model.common.MessageResponse;
import model.eventLog.EventLog;
import model.examParticipants.ExamParticipants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ExamParticipantsService;
import service.LogService;

import java.util.List;

@RestController
@RequestMapping("/examParticipants")
public class ExamParticipantsController {
    @Autowired
    private ExamParticipantsService examParticipantsService;
    @Autowired
    private LogService logService;

    @GetMapping("/getAll")
    public ResponseEntity<List<ExamParticipants>> getAllExamParticipants() {
        Long startTime = System.currentTimeMillis();
        String status = "success";
        List<ExamParticipants> examParticipants = null;
        try {
            examParticipants = examParticipantsService.getAllExamParticipants();
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        ExamParticipants examParticipant = null;
        try {
            examParticipant = examParticipantsService.getExamParticipantById(id);
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examParticipantsService.createExamParticipant(examParticipants);
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examParticipantsService.updateExamParticipant(id, examParticipants);
        } catch (Exception e) {
            status = "fail";
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
        Long startTime = System.currentTimeMillis();
        String status = "success";
        MessageResponse response = null;
        try {
            response = examParticipantsService.deleteExamParticipant(id);
        } catch (Exception e) {
            status = "fail";
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
