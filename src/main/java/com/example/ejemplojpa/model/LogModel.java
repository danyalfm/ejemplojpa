package com.example.ejemplojpa.model;

import lombok.Data;

import java.text.DateFormat;
import java.util.Date;

@Data
public class LogModel {
    private Date date;
    private String details;
    private String username;
    private String url;
    private int id;

    public LogModel() {

    }

    public LogModel( int id, Date date, String details, String username, String url) {
        this.date = date;
        this.details = details;
        this.username = username;
        this.url = url;
        this.id=id;
    }
}
