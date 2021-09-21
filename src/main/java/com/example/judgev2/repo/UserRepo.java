package com.example.judgev2.repo;

import com.example.judgev2.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsernameAndPassword(String username, String password);

    @Query("SELECT u.username FROM User u ORDER by u.username ASC")
    List<String> findAllUsernames();

    Optional<User> findByUsername(String username);
}
