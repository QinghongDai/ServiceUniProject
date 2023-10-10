package dao;


import model.exam.Exam;

import java.util.List;

public interface ExamDao {

    List<Exam> findAll();

    Exam findById(Integer id);

    int save(Exam exam);

    int update(Integer id, Exam exam);

    int deleteById(Integer id);
}
