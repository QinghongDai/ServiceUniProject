package com.program927.hrservice.dao;

import com.program927.hrservice.model.contract.Contract;
import com.program927.hrservice.model.contract.ContractRequest;
import java.util.List;

public interface ContractDao {
    List<Contract> findAll();

    Contract findById(Integer contractId);

    int save(Contract contract);

    int update(Integer contractId, ContractRequest contractRequest);

    int deleteById(Integer contractId);
}
