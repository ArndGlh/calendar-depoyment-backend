package com.bezkoder.spring.datajpa.repository;

import java.util.List;

import com.bezkoder.spring.datajpa.model.Application;
import com.bezkoder.spring.datajpa.model.Environment;
import com.bezkoder.spring.datajpa.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByApplicationAndEnvironment(Application application, Environment environment);
}
