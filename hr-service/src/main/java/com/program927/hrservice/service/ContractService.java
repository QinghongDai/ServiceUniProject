package com.program927.hrservice.service;

import com.program927.hrservice.model.common.MessageResponse;
import com.program927.hrservice.model.contract.Contract;
import com.program927.hrservice.model.contract.ContractRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ContractService {

    List<Contract> getAllContract();

    Contract getContractById(Integer contractId);

    MessageResponse createContract(ContractRequest contractRequest);

    MessageResponse updateContract(Integer contractId, ContractRequest contractRequest);

    MessageResponse deleteContract(Integer contractId);
}
