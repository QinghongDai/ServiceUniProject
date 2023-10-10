package com.program927.hrservice.service;

import com.program927.hrservice.model.common.MessageResponse;
import com.program927.hrservice.model.payroll.Payroll;

import java.util.List;

public interface PayrollService {
    List<Payroll> getAllPayroll();

    Payroll getPayrollById(Integer id);

    MessageResponse createPayroll(Payroll payroll);

    MessageResponse batchAdd(List<Payroll> payrolls);

    MessageResponse deletePayroll(Integer id);
}
