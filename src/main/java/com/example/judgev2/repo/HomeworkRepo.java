package com.example.judgev2.repo;

import com.example.judgev2.model.entity.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HomeworkRepo extends JpaRepository<Homework, Long> {

    Optional<Homework> findTop1ByOrderByComments();
}
