package com.program927.hrservice.dao.impl;

import com.program927.hrservice.dao.EmployeeDao;
import com.program927.hrservice.model.Employee;
import com.program927.hrservice.model.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> findAll() {
        String sql = "select * from employee";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public Employee findById(Integer employeeId) {
        String sql = "select * from employee where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{employeeId}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    @Override
    public int save(Employee newEmployee) {
        return jdbcTemplate.update("insert into csci927.employee (firstName, lastName, phoneNumber, email, salary, department) " +
                "values (?, ?, ?, ?, ?, ?)", newEmployee.getFirstName(), newEmployee.getLastname(),
                newEmployee.getPhoneNumber(), newEmployee.getEmail(), newEmployee.getSalary(), newEmployee.getDepartment());
    }

    @Override
    public int update(Integer employeeId, EmployeeRequest employeeRequest) {
        return jdbcTemplate.update("update csci927.employee set firstName = '" + employeeRequest.getFirstName() +
                        "', lastName = '"  + employeeRequest.getLastName() +
                        "', phoneNumber = '" + employeeRequest.getPhoneNumber() +
                        "', email = '" + employeeRequest.getEmail() +
                        "', salary = " + employeeRequest.getSalary() +
                        ", department = '" + employeeRequest.getDepartment() +
                        "' where id = " + employeeId);
    }

    @Override
    public int deleteById(Integer employeeId) {
        return jdbcTemplate.update("delete from employee where id = " + employeeId);
    }
}
