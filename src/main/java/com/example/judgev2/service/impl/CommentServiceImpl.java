package com.example.judgev2.service.impl;

import com.example.judgev2.model.entity.Comment;
import com.example.judgev2.model.service.CommentServiceModel;
import com.example.judgev2.repo.CommentRepo;
import com.example.judgev2.security.CurrentUser;
import com.example.judgev2.service.CommentService;
import com.example.judgev2.service.HomeworkService;
import com.example.judgev2.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepo commentRepo;
    private final HomeworkService homeworkService;
    private final UserService userService;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepo commentRepo, HomeworkService homeworkService, UserService userService, CurrentUser currentUser, ModelMapper modelMapper) {
        this.commentRepo = commentRepo;
        this.homeworkService = homeworkService;
        this.userService = userService;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveScoreAndComment(CommentServiceModel commentServiceModel, Long homeworkId) {
        commentServiceModel
                        .setHomework(homeworkService.findById(homeworkId))
                        .setAuthor(userService.findByUsername(currentUser.getUsername()));

        commentRepo.save(modelMapper.map(commentServiceModel, Comment.class));
    }

    @Override
    public List<String> getTopScoreStudents() {
        return commentRepo.findTopByAvgScore();
    }

    @Override
    public Double getAverageScore() {
        return commentRepo.getAvgScore();
    }
}
