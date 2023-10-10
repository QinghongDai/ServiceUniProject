package com.program927.examservice.service;

import com.program927.examservice.model.common.MessageResponse;
import com.program927.examservice.model.exam.Exam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExamService {

    List<Exam> getAllExams();

    Exam getExamById(Integer id);

    MessageResponse createExam(Exam exam);

    MessageResponse updateExam(Integer id, Exam exam);

    MessageResponse deleteExam(Integer id);
}
