package com.example.judgev2.service;

import com.example.judgev2.model.entity.Homework;
import com.example.judgev2.model.entity.User;
import com.example.judgev2.model.service.HomeworkServiceModel;

public interface HomeworkService {
    void addHomework(String exercise, String gitAddress);

    HomeworkServiceModel findLeastCommented();

    Homework findById(Long homeworkId);

    User findAuthorById(Long homeworkId);
}
