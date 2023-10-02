package com.program927.hrservice.dao.impl;

import com.program927.hrservice.dao.EventLogDao;
import com.program927.hrservice.model.EventLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventLogDaoImpl implements EventLogDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(EventLog eventLog) {
        jdbcTemplate.update("insert into csci927.eventlog (serviceProvider, serviceName, serviceFunction, status, startTime, endTime) " +
                        "values (?, ?, ?, ?, ?, ?)", eventLog.getServiceProvider(), eventLog.getServiceFunction(),
                        eventLog.getServiceFunction(), eventLog.getStatus(), eventLog.getStartTime(), eventLog.getEndTime());
    }
}
