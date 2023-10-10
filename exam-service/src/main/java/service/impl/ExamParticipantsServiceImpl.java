package service.impl;

import dao.ExamParticipantsDao;
import lombok.extern.log4j.Log4j;
import model.common.MessageResponse;
import model.examParticipants.ExamParticipants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ExamParticipantsService;

import java.util.List;

@Service
@Log4j
public class ExamParticipantsServiceImpl implements ExamParticipantsService {
    @Autowired
    private ExamParticipantsDao examParticipantsDao;

    @Override
    public List<ExamParticipants> getAllExamParticipants() {
        return examParticipantsDao.findAll();
    }
    @Override
    public ExamParticipants getExamParticipantById(Integer id) {
        return examParticipantsDao.findById(id);
    }

    @Override
    public MessageResponse createExamParticipant(ExamParticipants examParticipants) {
        int result = examParticipantsDao.save(examParticipants);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }

    @Override
    public MessageResponse updateExamParticipant(Integer id, ExamParticipants examParticipants){
        ExamParticipants examParticipant = examParticipantsDao.findById(id);
        if (null== examParticipant){
            return MessageResponse.builder().message("Fail").build();
        } else {
            int result = examParticipantsDao.update(id, examParticipants);
            if (0 == result){
                return MessageResponse.builder().message("Fail").build();
            }
            return MessageResponse.builder().message("Success").build();
        }
    }

    @Override
    public MessageResponse deleteExamParticipant(Integer id) {
        int result = examParticipantsDao.deleteById(id);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }
}
