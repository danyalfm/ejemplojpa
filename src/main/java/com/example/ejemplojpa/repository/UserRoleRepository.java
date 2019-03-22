package com.example.ejemplojpa.repository;

import com.example.ejemplojpa.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRoleRepository")
public interface UserRoleRepository extends JpaRepository<UserRole, Serializable> {
    public abstract UserRole findById(int userRoleId);
}
