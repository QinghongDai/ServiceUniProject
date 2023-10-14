package com.program927.examservice.service.impl;

import com.program927.examservice.dao.ExamDao;
import com.program927.examservice.model.common.MessageResponse;
import com.program927.examservice.model.exam.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.program927.examservice.service.ExamService;

import java.util.List;
@Service
public class ExamServiceImpl implements ExamService {
    @Autowired
    private ExamDao examDao;
    @Override
    public List<Exam> getAllExams() {
        return examDao.findAll();
    }

    @Override
    public Exam getExamById(Integer id) {
        return examDao.findById(id);
    }

    @Override
    public MessageResponse createExam(Exam exam) {
        int result = examDao.save(exam);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }

    @Override
    public MessageResponse updateExam(Integer id, Exam exam) {
        Exam examTemp = examDao.findById(id);
        if (null== examTemp){
            return MessageResponse.builder().message("Fail").build();
        } else {
            int result = examDao.update(id, exam);
            if (0 == result){
                return MessageResponse.builder().message("Fail").build();
            }
            return MessageResponse.builder().message("Success").build();
        }
    }

    @Override
    public MessageResponse deleteExam(Integer id) {
        int result = examDao.deleteById(id);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }
}
