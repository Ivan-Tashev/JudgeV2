package com.example.judgev2.repo;

import com.example.judgev2.model.entity.Role;
import com.example.judgev2.model.entity.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Optional<Role> findByName(RoleEnum roleEnum);
}
