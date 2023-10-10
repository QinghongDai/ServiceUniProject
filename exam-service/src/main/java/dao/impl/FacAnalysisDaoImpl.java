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
        String sql = "select count(distinct Temp.user) as totalUser, Temp.facilityId " +
                "from (select userType + userId as user, facilityId from facAppointment) as Temp " +
                "group by Temp.facilityId " +
                "ORDER By totalUser DESC LIMIT 10;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FacAnalysis.class));
    }

    @Override
    public List<FacAnalysis> getTopRatesFacilities() {
        String sql = "select count(*) as totalAppointment, facilityId " +
                "from facAppointment " +
                "group by facilityId " +
                "ORDER By totalAppointment DESC LIMIT 10;";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FacAnalysis.class));
    }
}
