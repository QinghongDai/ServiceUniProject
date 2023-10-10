package dao.impl;

import dao.FacAnalysisDao;
import model.facAnalysis.FacAnalysis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacAnalysisDaoImpl implements FacAnalysisDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FacAnalysis> getTopPopularFacilities() {
        String sql = "select * from facAppointment";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FacAnalysis.class));
    }

    @Override
    public List<FacAnalysis> getTopRatesFacilities() {
        String sql = "select * from facAppointment";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FacAnalysis.class));
    }
}
