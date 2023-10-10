package com.program927.facilityservice.dao.impl;

import com.program927.facilityservice.model.facility.Facility;
import com.program927.facilityservice.dao.FacilityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityDaoImpl implements FacilityDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Facility> findAll() {
        String sql = "select * from facility";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Facility.class));
    }

    @Override
    public Facility findById(Integer id) {
        String sql = "select * from facility where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Facility.class));
    }

    @Override
    public int save(Facility facility) {
        return jdbcTemplate.update("insert into csci927.facility (name, location, startDate, status) " +
                "values (?, ?, ?, ?, ?, ?, ?)", facility.getName(), facility.getLocation(), facility.getStartDate(), facility.getStatus());
    }

    @Override
    public int update(Integer id, Facility facility) {
        return jdbcTemplate.update("update csci927.facility set status = '" + facility.getStatus() + "', location = '" + facility.getLocation() +
                "' where id = " + id);
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("delete from facility where id = " + id);
    }
}
