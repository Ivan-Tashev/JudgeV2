package com.example.judgev2.service.impl;

import com.example.judgev2.model.entity.Homework;
import com.example.judgev2.model.entity.User;
import com.example.judgev2.model.service.HomeworkServiceModel;
import com.example.judgev2.repo.HomeworkRepo;
import com.example.judgev2.security.CurrentUser;
import com.example.judgev2.service.ExerciseService;
import com.example.judgev2.service.HomeworkService;
import com.example.judgev2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkRepo homeworkRepo;
    private final CurrentUser currentUser;
    private final UserService userService;
    private final ExerciseService exerciseService;
    private final ModelMapper modelMapper;

    public HomeworkServiceImpl(HomeworkRepo homeworkRepo, CurrentUser currentUser, UserService userService, ExerciseService exerciseService, ModelMapper modelMapper) {
        this.homeworkRepo = homeworkRepo;
        this.currentUser = currentUser;
        this.userService = userService;
        this.exerciseService = exerciseService;
        this.modelMapper = modelMapper;
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

    @Override
    public HomeworkServiceModel findLeastCommented() {
        Optional<Homework> top1OrderByComments = homeworkRepo.findTop1ByOrderByComments();

        HomeworkServiceModel homeworkServiceModel = modelMapper.map(top1OrderByComments.get(), HomeworkServiceModel.class);

        return homeworkServiceModel;
    }

    @Override
    public Homework findById(Long homeworkId) {
        return homeworkRepo.findById(homeworkId).orElse(null);
    }

    @Override
    public User findAuthorById(Long homeworkId) {
        Homework homework = homeworkRepo.findById(homeworkId).orElse(null);
        return homework.getAuthor();
    }
}
