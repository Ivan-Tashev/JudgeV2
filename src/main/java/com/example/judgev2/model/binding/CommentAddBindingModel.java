package com.example.judgev2.model.binding;

import javax.validation.constraints.*;

public class CommentAddBindingModel {

    private Long homeworkId;
    @Min(2) @Max(6)
    private Integer score;
    @NotBlank @Size(min = 3)
    private String textContent;

    public Long getHomeworkId() {
        return homeworkId;
    }

    public CommentAddBindingModel setHomeworkId(Long homeworkId) {
        this.homeworkId = homeworkId;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public CommentAddBindingModel setScore(Integer score) {
        this.score = score;
        return this;
    }

    public String getTextContent() {
        return textContent;
    }

    public CommentAddBindingModel setTextContent(String textContent) {
        this.textContent = textContent;
        return this;
    }
}
