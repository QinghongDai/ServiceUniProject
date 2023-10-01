package com.program927.hrservice.model;

import lombok.Data;

@Data
public class Employee {
    private Integer id;
    private String firstName;
    private String lastname;
    private String phoneNumber;
    private String email;
    private double salary;
    private String department;
}
