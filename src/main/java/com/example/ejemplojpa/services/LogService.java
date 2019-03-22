package com.example.ejemplojpa.services;


import com.example.ejemplojpa.entity.Log;
import com.example.ejemplojpa.model.LogModel;

import java.util.List;

public interface LogService {
    public abstract LogModel addLog(LogModel logModel);

    public abstract List<LogModel> listAllLogs();

    public abstract Log findLogById(int id);

    public abstract void removeLog(int id);

    public abstract LogModel findLogByIdModel(int id);
}
