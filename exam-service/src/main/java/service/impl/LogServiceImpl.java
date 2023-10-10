package service.impl;

import dao.EventLogDao;
import model.eventLog.EventLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import service.LogService;

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
