package com.program927.hrservice.dao.impl;

import com.program927.hrservice.dao.ContractDao;
import com.program927.hrservice.model.contract.Contract;
import com.program927.hrservice.model.contract.ContractRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDaoImpl implements ContractDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Contract> findAll() {
        String sql = "select * from contract";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Contract.class));
    }

    @Override
    public Contract findById(Integer contractId) {
        String sql = "select * from contract where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{contractId}, new BeanPropertyRowMapper<>(Contract.class));
    }

    @Override
    public int save(Contract contract) {
        return jdbcTemplate.update("insert into csci927.contract (employeeId, type, status, contractName, signDate, expireDate, fileUrl) " +
                "values (?, ?, ?, ?, ?, ?, ?)", contract.getEmployeeId(), contract.getType(), contract.getStatus(), contract.getContractName(),
                contract.getSignDate(), contract.getExpireDate(), contract.getFileUrl());
    }

    @Override
    public int update(Integer contractId, ContractRequest contractRequest) {
        return jdbcTemplate.update("update csci927.contract set status = '" + contractRequest.getStatus() +
                "' where id = " + contractId);
    }

    @Override
    public int deleteById(Integer contractId) {
        return jdbcTemplate.update("delete from contract where id = " + contractId);
    }
}
