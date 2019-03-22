package com.example.ejemplojpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user_roles", uniqueConstraints = @UniqueConstraint(
        columnNames = {"role", "username"}
))
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "user_role_id", unique = true, nullable = false)
    private int userRoleId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "username", nullable = false)
    private User user;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

    public UserRole() {

    }

    public UserRole(User user, String role, int userRoleId) {
        this.user = user;
        this.role = role;
        this.userRoleId = userRoleId;
    }


}
