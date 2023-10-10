package com.program927.facilityservice.model.facAppointment;

import lombok.Data;

@Data
public class FacAppointment {
    private Integer id;
    private Integer facilityId;
    private String userType;
    private Integer userId;
    private String applyStartTime;
    private String applyEndTime;
    private String status;
    private String approveManagerName;
    private String approveDate;
}
