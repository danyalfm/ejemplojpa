package com.example.ejemplojpa.components;

import com.example.ejemplojpa.entity.Log;
import com.example.ejemplojpa.model.LogModel;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.util.Date;

@Component("logConverter")
public class LogConverter {


    public Log convertToLogModel2Log(LogModel logModel) {
        Log log = new Log();
        logModel.getDate().split("T");
        log.setDate(logModel.getDate());
        log.setDetails(logModel.getDetails());
        log.setUrl(logModel.getUrl());
        log.setUsername(logModel.getUsername());
        log.setId(logModel.getId());
        return log;
    }

    public LogModel convertLog2LogModel(Log log) {
        LogModel logModel = new LogModel();
        log.getDate().split("T");
        logModel.setDate(log.getDate());
        logModel.setDetails(log.getDetails());
        logModel.setUrl(log.getUrl());
        logModel.setUsername(log.getUsername());
        logModel.setId(log.getId());
        return logModel;
    }
}

