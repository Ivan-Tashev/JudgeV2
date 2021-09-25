package com.example.judgev2.service;

import com.example.judgev2.model.service.CommentServiceModel;

public interface CommentService {
    void saveScoreAndComment(CommentServiceModel commentAddBindingModel, Long homeworkId);
}
