package com.example.judgev2.service;

import com.example.judgev2.model.binding.ExerciseAddBindingModel;

public interface ExerciseService {

    void addExercise(ExerciseAddBindingModel exerciseAddBindingModel);

    boolean checkIfExist(String name);
}
