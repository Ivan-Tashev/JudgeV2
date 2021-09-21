package com.example.judgev2.service.impl;

import com.example.judgev2.model.entity.Homework;
import com.example.judgev2.repo.HomeworkRepo;
import com.example.judgev2.security.CurrentUser;
import com.example.judgev2.service.ExerciseService;
import com.example.judgev2.service.HomeworkService;
import com.example.judgev2.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepo homeworkRepo;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ExerciseService exerciseService;

    public HomeworkServiceImpl(HomeworkRepo homeworkRepo, CurrentUser currentUser, UserService userService, ExerciseService exerciseService) {
        this.homeworkRepo = homeworkRepo;
        this.currentUser = currentUser;
        this.userService = userService;
        this.exerciseService = exerciseService;
    }

    @Override
    public void addHomework(String exercise, String gitAddress) {
        final Homework homework = new Homework();
        homework.setAuthor(userService.findByUsername(currentUser.getUsername()));
        homework.setExercise(exerciseService.findExerciseByName(exercise));
        homework.setGitAddress(gitAddress);
        homework.setAddedOn(LocalDateTime.now());
        homeworkRepo.save(homework);
    }
}
