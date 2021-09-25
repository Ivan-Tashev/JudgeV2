package com.example.judgev2.service;

import com.example.judgev2.model.service.CommentServiceModel;
import com.example.judgev2.model.service.UserServiceModel;

import java.util.List;

public interface CommentService {
    void saveScoreAndComment(CommentServiceModel commentAddBindingModel, Long homeworkId);

    List<String> getTopScoreStudents();

    Double getAverageScore();
}
