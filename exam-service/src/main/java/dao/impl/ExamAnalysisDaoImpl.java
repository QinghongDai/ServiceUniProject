package dao.impl;

import dao.ExamAnalysisDao;
import model.examAnalysis.ExamAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamAnalysisDaoImpl implements ExamAnalysisDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ExamAnalysis> getTopPopularExams() {
        String sql = "select count(distinct userId) as totalParticipants, examId " +
                "from examParticipants" +
                "group by examId " +
                "ORDER By totalParticipants DESC LIMIT 10;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ExamAnalysis.class));
    }

    @Override
    public List<ExamAnalysis> getTopFailRatesExams() {
        String sql = "select (SUM(CASE WHEN score < 50 THEN 1 ELSE 0 END) / COUNT(*)) AS failRates, examId " +
                "from examParticipants where status = 0" +
                "group by examId " +
                "ORDER By failRates DESC LIMIT 10;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ExamAnalysis.class));
    }
}
