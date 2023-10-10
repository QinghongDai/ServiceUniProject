package com.program927.hrservice.service.impl;

import com.program927.hrservice.dao.PayrollDao;
import com.program927.hrservice.model.common.MessageResponse;
import com.program927.hrservice.model.payroll.Payroll;
import com.program927.hrservice.service.PayrollService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Log4j
public class PayrollServiceImpl implements PayrollService {
    @Autowired
    private PayrollDao payrollDao;

    @Override
    public List<Payroll> getAllPayroll() {
        return payrollDao.findAll();
    }

    @Override
    public Payroll getPayrollById(Integer id) {
        return payrollDao.findById(id);
    }

    @Override
    public MessageResponse createPayroll(Payroll payroll) {
        int result = payrollDao.save(payroll);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }

    @Override
    @Transactional
    public MessageResponse batchAdd(List<Payroll> payrolls){
        payrolls.forEach(payroll -> {
            payrollDao.save(payroll);
        });
        return MessageResponse.builder().message("Success").build();
    }

    @Override
    public MessageResponse deletePayroll(Integer id) {
        int result = payrollDao.deleteById(id);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }
}
