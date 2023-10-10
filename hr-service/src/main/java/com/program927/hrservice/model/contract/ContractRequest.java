package com.program927.hrservice.model.contract;

import lombok.Data;

@Data
public class ContractRequest {
    private String id;
    private Integer employeeId;
    private String type;
    private Integer status;
}
