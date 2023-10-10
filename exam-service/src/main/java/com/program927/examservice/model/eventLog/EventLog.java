package com.program927.examservice.model.eventLog;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EventLog {

    private int id;
    private String serviceProvider;
    private String serviceName;
    private String serviceFunction;
    private String status;
    private Long startTime;
    private Long endTime;
}