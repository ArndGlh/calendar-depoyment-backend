package com.bezkoder.spring.datajpa.repository;

import java.util.List;
import java.util.Optional;
import com.bezkoder.spring.datajpa.model.Application;
import com.bezkoder.spring.datajpa.model.enums.EApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
    List<Application> findAll();
    Optional<Application> findByApplication(EApplication eApplication);
}

