package com.program927.hrservice.dao.impl;

import com.program927.hrservice.dao.EmployeeDao;
import com.program927.hrservice.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(Employee newEmployee) {
        String sql = "";
    }

    @Override
    public Optional<Employee> findById(Integer employeeId) {
        return Optional.empty();
    }

    @Override
    public List<Employee> findAll() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public void deleteById(Integer employeeId) {

    }
}
