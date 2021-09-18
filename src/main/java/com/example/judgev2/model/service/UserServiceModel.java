package com.example.judgev2.model.service;

import com.example.judgev2.model.entity.Role;

public class UserServiceModel {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String git;
    private Role role;

    public Long getId() {
        return id;
    }

    public UserServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserServiceModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserServiceModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGit() {
        return git;
    }

    public UserServiceModel setGit(String git) {
        this.git = git;
        return this;
    }

    public Role getRole() {
        return role;
    }

    public UserServiceModel setRole(Role role) {
        this.role = role;
        return this;
    }
}
