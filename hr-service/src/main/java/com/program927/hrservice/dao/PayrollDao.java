package com.program927.hrservice.dao;

import com.program927.hrservice.model.payroll.Payroll;

import java.util.List;

public interface PayrollDao {
    List<Payroll> findAll();

    Payroll findById(Integer id);

    int save(Payroll payroll);

    int deleteById(Integer id);
}
