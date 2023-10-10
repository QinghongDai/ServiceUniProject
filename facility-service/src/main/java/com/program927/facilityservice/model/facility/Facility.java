package com.program927.facilityservice.model.facility;

import lombok.Data;

@Data
public class Facility {
    private Integer id;
    private String name;
    private String location;
    private String startDate;
    private String status;
}
