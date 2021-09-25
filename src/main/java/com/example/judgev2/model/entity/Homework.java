package com.example.judgev2.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "homework")
public class Homework extends BaseEntity{
    @Column(name = "added_on", nullable = false)
    private LocalDateTime addedOn;
    @Column(name = "git_address", nullable = false)
    private String gitAddress;
    @ManyToOne
    private User author;
    @ManyToOne
    private Exercise exercise;
    @OneToMany(mappedBy = "homework", fetch = FetchType.EAGER)
    private Set<Comment> comments;

    public LocalDateTime getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(LocalDateTime addedOn) {
        this.addedOn = addedOn;
    }

    public String getGitAddress() {
        return gitAddress;
    }

    public void setGitAddress(String gitAddress) {
        this.gitAddress = gitAddress;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Exercise getExercise() {
        return exercise;
    }

    public void setExercise(Exercise exercise) {
        this.exercise = exercise;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public Homework setComments(Set<Comment> comments) {
        this.comments = comments;
        return this;
    }
}
