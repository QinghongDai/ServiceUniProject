package com.program927.hrservice.dao;

import com.program927.hrservice.model.contract.Contract;
import com.program927.hrservice.model.contract.ContractRequest;

import java.util.List;

public interface ContractDao {
    List<Contract> getAllContract();

    Contract getContractById(Integer contractId);

    int createContract(Contract contract);

    int updateContract(Integer contractId, ContractRequest contractRequest);

    int deleteContract(Integer contractId);
}
