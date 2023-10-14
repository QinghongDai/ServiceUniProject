package com.program927.hrservice.model.employee;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private double salary;
    private String department;
}
