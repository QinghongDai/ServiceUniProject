package com.program927.hrservice.service.impl;

import com.program927.hrservice.dao.EventLogDao;
import com.program927.hrservice.model.eventLog.EventLog;
import com.program927.hrservice.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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
