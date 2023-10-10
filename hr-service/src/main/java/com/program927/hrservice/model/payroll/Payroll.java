package com.program927.hrservice.model.payroll;

import lombok.Data;

@Data
public class Payroll {
    private Integer id;
    private Integer employeeId;
    private Integer contractId;
    private String period;
    private double wages;
    private double tax;
    private double superPay;
    private double otherPay;
    private double realPay;
}
