package com.example.judgev2.security;

import com.example.judgev2.model.entity.enums.RoleEnum;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope // return new CurrentUser for each Session
public class CurrentUser {
    private Long id;
    private String username;
    private RoleEnum role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public boolean isAnonymous() {
        return this.username == null;
    }

    public boolean isAdmin() {
        return this.role == RoleEnum.ADMIN;
    }
}
