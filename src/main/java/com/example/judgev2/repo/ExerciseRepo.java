package com.example.judgev2.repo;

import com.example.judgev2.model.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise, Long> {

    Exercise findByName(String name);

    @Query("SELECT e.name FROM Exercise e ORDER BY e.startedOn")
    List<String> findAllNames();
}
