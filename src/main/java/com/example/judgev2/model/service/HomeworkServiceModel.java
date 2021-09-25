package com.example.judgev2.model.service;

public class HomeworkServiceModel {
    private Long id;
    private String gitAddress;

    public Long getId() {
        return id;
    }

    public HomeworkServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public HomeworkServiceModel setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
        return this;
    }
}
