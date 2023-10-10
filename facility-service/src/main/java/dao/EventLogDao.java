package dao;

import model.eventLog.EventLog;
public interface EventLogDao {
    void save(EventLog eventLog);
}
