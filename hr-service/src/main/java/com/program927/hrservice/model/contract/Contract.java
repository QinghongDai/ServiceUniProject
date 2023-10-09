package com.program927.hrservice.model.contract;

import lombok.Data;

@Data
public class Contract {
    private Integer id;
    private String type;
    private String employeeId;
    private Integer status;
    private Data signDate;
    private Data expireDate;
    private String contractName;
    private String fileUrl;
}
