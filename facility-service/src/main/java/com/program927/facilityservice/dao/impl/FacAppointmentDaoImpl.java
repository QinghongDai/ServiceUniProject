package com.program927.facilityservice.dao.impl;

import com.program927.facilityservice.dao.FacAppointmentDao;
import com.program927.facilityservice.model.facAppointment.FacAppointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacAppointmentDaoImpl implements FacAppointmentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<FacAppointment> findAll() {
        String sql = "select * from facAppointment";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(FacAppointment.class));
    }

    @Override
    public FacAppointment findById(Integer id) {
        String sql = "select * from facAppointment where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(FacAppointment.class));
    }

    @Override
    public int save(FacAppointment facAppointment) {
        return jdbcTemplate.update("insert into csci927.facAppointment (facilityId, userType, userId, applyStartTime, applyEndTime, status, approveManagerName, approveDate) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?)", facAppointment.getFacilityId(), facAppointment.getUserType(), facAppointment.getUserId(), facAppointment.getApplyStartTime(),
                facAppointment.getApplyEndTime(), facAppointment.getStatus(), facAppointment.getApproveManagerName(), facAppointment.getApproveDate());
    }

    @Override
    public int update(Integer id, FacAppointment facAppointment) {
        return jdbcTemplate.update("update csci927.facAppointment set approveManagerName = '" + facAppointment.getApproveManagerName() +
                        "', approveDate = '"  + facAppointment.getApproveDate() +
                        "' where id = " + id);
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("delete from facAppointment where id = " + id);
    }
}
