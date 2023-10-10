package com.program927.facilityservice.service.impl;

import com.program927.facilityservice.dao.EventLogDao;
import com.program927.facilityservice.model.eventLog.EventLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.program927.facilityservice.service.LogService;

@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private EventLogDao eventLogDao;

    @Override
    @Async
    public void addLog(EventLog eventLog) {
        eventLogDao.save(eventLog);
    }
}
