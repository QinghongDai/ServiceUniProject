package com.program927.hrservice.model;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private double salary;
    private String department;
}
