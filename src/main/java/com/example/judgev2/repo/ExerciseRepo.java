package com.example.judgev2.repo;

import com.example.judgev2.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepo extends JpaRepository<Exercise, Long> {

    Exercise findByName(String name);
}
