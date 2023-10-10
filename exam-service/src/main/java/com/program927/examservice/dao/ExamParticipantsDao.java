package com.program927.examservice.dao;

import com.program927.examservice.model.examParticipants.ExamParticipants;

import java.util.List;

public interface ExamParticipantsDao {

    List<ExamParticipants> findAll();

    ExamParticipants findById(Integer id);

    int save(ExamParticipants examParticipant);

    int update(Integer id, ExamParticipants examParticipant);

    int deleteById(Integer id);
}
