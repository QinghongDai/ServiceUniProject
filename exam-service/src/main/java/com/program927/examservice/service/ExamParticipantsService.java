package com.program927.examservice.service;

import com.program927.examservice.model.common.MessageResponse;
import com.program927.examservice.model.examParticipants.ExamParticipants;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ExamParticipantsService {


    List<ExamParticipants> getAllExamParticipants();

    ExamParticipants getExamParticipantById(Integer id);

    MessageResponse createExamParticipant(ExamParticipants facAppointment);

    MessageResponse updateExamParticipant(Integer id, ExamParticipants facAppointment);

    MessageResponse deleteExamParticipant(Integer id);
}
