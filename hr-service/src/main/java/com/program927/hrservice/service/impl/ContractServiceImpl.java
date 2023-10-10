package com.program927.hrservice.service.impl;

import com.program927.hrservice.dao.ContractDao;
import com.program927.hrservice.model.common.MessageResponse;
import com.program927.hrservice.model.contract.Contract;
import com.program927.hrservice.model.contract.ContractRequest;
import com.program927.hrservice.service.ContractService;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Log4j
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractDao contractDao;
    @Override
    public List<Contract> getAllContract() {
        return contractDao.findAll();
    }

    @Override
    public Contract getContractById(Integer contractId) {
        return contractDao.findById(contractId);
    }

    @Override
    public MessageResponse createContract(Contract contract) {
        int result = contractDao.save(contract);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }

    @Override
    public MessageResponse updateContract(Integer contractId, ContractRequest contractRequest) {
        Contract contract = contractDao.findById(contractId);
        if (null== contract){
            return MessageResponse.builder().message("Fail").build();
        } else {
            int result = contractDao.update(contractId, contractRequest);
            if (0 == result){
                return MessageResponse.builder().message("Fail").build();
            }
            return MessageResponse.builder().message("Success").build();
        }
    }

    @Override
    public MessageResponse deleteContract(Integer contractId) {
        int result = contractDao.deleteById(contractId);
        if (0 == result){
            return MessageResponse.builder().message("Fail").build();
        }
        return MessageResponse.builder().message("Success").build();
    }
}
