package service;

import model.common.MessageResponse;
import model.exam.Exam;
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
