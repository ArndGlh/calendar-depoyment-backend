package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Environment;
import com.bezkoder.spring.datajpa.model.enums.EEnvironment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EnvironmentRepository extends JpaRepository<Environment, Long> {
    List<Environment> findAll();
    Optional<Environment> findByEnvironment(EEnvironment eEnvironment);
}

