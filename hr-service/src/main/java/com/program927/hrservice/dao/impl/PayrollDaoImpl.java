package com.program927.hrservice.dao.impl;

import com.program927.hrservice.dao.PayrollDao;
import com.program927.hrservice.model.payroll.Payroll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayrollDaoImpl implements PayrollDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Payroll> findAll() {
        String sql = "select * from payroll";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Payroll.class));
    }

    @Override
    public Payroll findById(Integer id) {
        String sql = "select * from payroll where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Payroll.class));
    }

    @Override
    public int save(Payroll payroll) {
        return jdbcTemplate.update("insert into csci927.payroll (employeeId, contractId, period, wages, tax, superPay, otherPay, realPay) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?)", payroll.getEmployeeId(), payroll.getContractId(), payroll.getPeriod(), payroll.getWages(),
                payroll.getTax(), payroll.getSuperPay(), payroll.getOtherPay(), payroll.getRealPay());
    }

    @Override
    public int deleteById(Integer id) {
        return jdbcTemplate.update("delete from payroll where id = " + id);
    }
}
