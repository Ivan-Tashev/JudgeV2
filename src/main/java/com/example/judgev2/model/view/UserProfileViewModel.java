package com.example.judgev2.model.view;

import java.util.Set;

public class UserProfileViewModel {
    private String username;
    private String email;
    private String git;
    private Set<String> homeworks;

    public String getUsername() {
        return username;
    }

    public UserProfileViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserProfileViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getGit() {
        return git;
    }

    public UserProfileViewModel setGit(String git) {
        this.git = git;
        return this;
    }

    public Set<String> getHomeworks() {
        return homeworks;
    }

    public UserProfileViewModel setHomeworks(Set<String> homeworks) {
        this.homeworks = homeworks;
        return this;
    }
}
