package com.example.judgev2.model.service;

import com.example.judgev2.model.entity.Homework;
import com.example.judgev2.model.entity.User;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceModel {
    private Long id;
    private Long homeworkId;
    private Integer score;
    private String textContent;
    private User author;
    private Homework homework;

    public Long getId() {
        return id;
    }

    public CommentServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public Long getHomeworkId() {
        return homeworkId;
    }

    public CommentServiceModel setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public CommentServiceModel setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentServiceModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }

    public User getAuthor() {
        return author;
    }

    public CommentServiceModel setAuthor(User author) {
        this.author = author;
        return this;
    }

    public Homework getHomework() {
        return homework;
    }

    public CommentServiceModel setHomework(Homework homework) {
        this.homework = homework;
        return this;
    }
}
