package com.example.judgev2.repo;

import com.example.judgev2.model.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment, Long> {

    @Query("SELECT c.author.username FROM Comment c GROUP BY c.author.username ORDER BY avg(c.score) DESC")
    List<String> findTopByAvgScore();

    @Query("SELECT AVG(c.score) FROM Comment c")
    Double getAvgScore();
}
