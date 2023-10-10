package dao.impl;

import dao.ExamParticipantsDao;
import model.examParticipants.ExamParticipants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamParticipantsDaoImpl implements ExamParticipantsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ExamParticipants> findAll() {
        String sql = "select * from examParticipants";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ExamParticipants.class));
    }

    @Override
    public ExamParticipants findById(Integer id) {
        String sql = "select * from examParticipants where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(ExamParticipants.class));
    }

    @Override
    public int save(ExamParticipants examParticipant) {
        return jdbcTemplate.update("insert into csci927.examParticipants (examId, userId, score, status) " +
                "values (?, ?, ?, ?)", examParticipant.getExamId(), examParticipant.getUserId(), examParticipant.getScore(), examParticipant.getStatus());
    }

    @Override
    public int update(Integer id, ExamParticipants examParticipant) {
        return jdbcTemplate.update("update csci927.examParticipants set score = '" + examParticipant.getScore() +
                        "', status = '"  + examParticipant.getStatus() +
                        "' where id = " + id);
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("delete from examParticipants where id = " + id);
    }
}
