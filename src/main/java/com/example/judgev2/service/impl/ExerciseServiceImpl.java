package com.example.judgev2.service.impl;

import com.example.judgev2.model.binding.ExerciseAddBindingModel;
import com.example.judgev2.model.entity.Exercise;
import com.example.judgev2.repo.ExerciseRepo;
import com.example.judgev2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepo exerciseRepo;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepo exerciseRepo, ModelMapper modelMapper) {
        this.exerciseRepo = exerciseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseAddBindingModel exerciseAddBindingModel) {
        Exercise exercise = modelMapper.map(exerciseAddBindingModel, Exercise.class);
        exerciseRepo.save(exercise);
    }

    @Override
    public boolean checkIfExist(String name) {
        return exerciseRepo.findByName(name) == null;
    }
}
