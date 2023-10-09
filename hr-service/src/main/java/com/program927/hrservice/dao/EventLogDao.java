package com.program927.hrservice.dao;

import com.program927.hrservice.model.eventLog.EventLog;

public interface EventLogDao {
    void save(EventLog eventLog);
}
