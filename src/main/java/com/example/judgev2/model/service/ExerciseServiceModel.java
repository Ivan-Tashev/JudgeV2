package com.example.judgev2.model.service;

import java.time.LocalDateTime;

public class ExerciseServiceModel {
    private Long id;
    private String name;
    private LocalDateTime startedOn;
    private LocalDateTime dueDate;

    public Long getId() {
        return id;
    }

    public ExerciseServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ExerciseServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getStartedOn() {
        return startedOn;
    }

    public ExerciseServiceModel setStartedOn(LocalDateTime startedOn) {
        this.startedOn = startedOn;
        return this;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public ExerciseServiceModel setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
        return this;
    }
}
