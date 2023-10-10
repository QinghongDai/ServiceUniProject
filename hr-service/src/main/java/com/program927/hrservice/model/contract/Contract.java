package com.program927.hrservice.model.contract;

import lombok.Data;

@Data
public class Contract {
    private Integer id;
    private String type;
    private Integer employeeId;
    private Integer status;
    private String signDate;
    private String expireDate;
    private String contractName;
    private String fileUrl;
}
