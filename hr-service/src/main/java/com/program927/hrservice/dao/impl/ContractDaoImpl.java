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
    public List<Contract> getAllContract() {
        String sql = "select * from contract";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Contract>(Contract.class));
    }

    @Override
    public Contract getContractById(Integer contractId) {
        String sql = "select * from contract where id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{contractId}, new BeanPropertyRowMapper<Contract>(Contract.class));
    }

    @Override
    public int createContract(Contract contract) {
        return jdbcTemplate.update("insert into csci927.contract (employeeId, type, status) values (?, ?, ?)",
                contract.getEmployeeId(), contract.getType(), contract.getStatus());
    }

    @Override
    public int updateContract(Integer contractId, ContractRequest contractRequest) {
        return jdbcTemplate.update("update csci927.contract set status = '" + contractRequest.getStatus() +
                "' where id = " + contractId);
    }

    @Override
    public int deleteContract(Integer contractId) {
        return jdbcTemplate.update("delete from contract where id = " + contractId);
    }
}
