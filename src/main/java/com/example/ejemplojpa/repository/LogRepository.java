package com.example.ejemplojpa.repository;


import com.example.ejemplojpa.entity.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("logRepository")
public interface LogRepository extends JpaRepository<Log, Serializable> {
    public abstract Log findById(int id);
}

