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

    public CurrentUser setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;
        return this;
    }

    public RoleEnum getRole() {
        return role;
    }

    public CurrentUser setRole(RoleEnum role) {
        this.role = role;
        return this;
    }

    public boolean isAnonymous() {
        return this.username == null;
    }

    public boolean isAdmin () {
        return this.role == RoleEnum.ADMIN;
    }
}
