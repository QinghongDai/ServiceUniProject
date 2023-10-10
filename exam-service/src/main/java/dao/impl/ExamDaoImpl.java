package dao.impl;

import dao.ExamDao;
import model.exam.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamDaoImpl implements ExamDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Exam> findAll() {
        String sql = "select * from exam";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Exam.class));
    }

    @Override
    public Exam findById(Integer id) {
        String sql = "select * from exam where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Exam.class));
    }

    @Override
    public int save(Exam exam) {
        return jdbcTemplate.update("insert into csci927.exam (type, subjectName, location, startTime, takeMins) " +
                "values (?, ?, ?, ?, ?)", exam.getType(), exam.getSubjectName(), exam.getLocation(), exam.getStartTime(), exam.getTakeMins());
    }

    @Override
    public int update(Integer id, Exam exam) {
        return jdbcTemplate.update("update csci927.exam set location = '" + exam.getLocation() + "', startTime = '" + exam.getStartTime() +
                "', takeMins = '" + exam.getTakeMins() + "' where id = " + id);
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("delete from exam where id = " + id);
    }
}
