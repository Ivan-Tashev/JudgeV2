package com.example.judgev2.service;

import com.example.judgev2.model.entity.Exercise;
import com.example.judgev2.model.service.ExerciseServiceModel;

import java.util.List;

public interface ExerciseService {

    void addExercise(ExerciseServiceModel exerciseAddBindingModel);

    boolean checkIfExist(String name);

    List<String> findAllExerciseNames();

    Exercise findExerciseByName(String exercise);

    boolean isExpiredByName(String exercise);
}
