package com.example.judgev2.service.impl;

import com.example.judgev2.model.entity.Exercise;
import com.example.judgev2.model.service.ExerciseServiceModel;
import com.example.judgev2.repo.ExerciseRepo;
import com.example.judgev2.service.ExerciseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    private final ExerciseRepo exerciseRepo;
    private final ModelMapper modelMapper;

    public ExerciseServiceImpl(ExerciseRepo exerciseRepo, ModelMapper modelMapper) {
        this.exerciseRepo = exerciseRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public void addExercise(ExerciseServiceModel exerciseServiceModel) {
        Exercise exercise = modelMapper.map(exerciseServiceModel, Exercise.class);
        exerciseRepo.save(exercise);
    }

    @Override
    public boolean checkIfExist(String name) {
        return exerciseRepo.findByName(name) == null;
    }

    @Override
    public List<String> findAllExerciseNames() {
        return exerciseRepo.findAllNames();
    }

    @Override
    public Exercise findExerciseByName(String exercise) {
        return exerciseRepo.findByName(exercise);
    }

    @Override
    public boolean isExpiredByName(String exercise) {
        return exerciseRepo.findByName(exercise)
                .getDueDate()
                .isBefore(LocalDateTime.now());
    }
}
