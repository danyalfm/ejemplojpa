package com.example.ejemplojpa.services.impl;

import com.example.ejemplojpa.components.LogConverter;
import com.example.ejemplojpa.entity.Log;
import com.example.ejemplojpa.model.LogModel;
import com.example.ejemplojpa.repository.LogRepository;
import com.example.ejemplojpa.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("logServiceImpl")
public class LogServiceImpl implements LogService {

    @Autowired
    @Qualifier("logRepository")
    private LogRepository logRepository;

    @Autowired
    @Qualifier("logConverter")
    private LogConverter logConverter;

    @Override
    public LogModel addLog(LogModel logModel) {
        //Aquí nos pide una entidad, por lo tanto tenemos que transformar el contactModel a entidad
        Log temp = logConverter.convertToLogModel2Log(logModel);
        Log log = logRepository.save(temp);
        return logConverter.convertLog2LogModel(log);
    }

    @Override
    public List<LogModel> listAllLogs() {
        List<Log> logs = logRepository.findAll();
        List<LogModel> logsModel = new ArrayList();
        for (Log log : logs) {
            logsModel.add(logConverter.convertLog2LogModel(log));

        }
        return logsModel;
    }

    @Override
    public Log findLogById(int id) {
        return logRepository.findById(id);
    }

    public LogModel findLogByIdModel(int id) {
        return logConverter.convertLog2LogModel(findLogById(id));
    }

    @Override
    public void removeLog(int id) {
        Log log = findLogById(id);
        if (log != null) {
            logRepository.delete(findLogById(id));
        }
    }


}