package com.bezkoder.spring.datajpa.controller;

import java.io.IOException;
import java.util.List;

import com.bezkoder.spring.datajpa.model.*;
import com.bezkoder.spring.datajpa.model.enums.EApplication;
import com.bezkoder.spring.datajpa.model.enums.EEnvironment;
import com.bezkoder.spring.datajpa.repository.ApplicationRepository;
import com.bezkoder.spring.datajpa.repository.AuthorRepository;
import com.bezkoder.spring.datajpa.repository.EnvironmentRepository;
import com.bezkoder.spring.datajpa.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    EventRepository eventRepository;

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    EnvironmentRepository environmentRepository;

    @Autowired
    AuthorRepository authorRepository;

    @GetMapping("/{application}/{environment}")
    public ResponseEntity<List<Event>> findByApplicationAndEnvironment(
            @PathVariable("application") String application,
            @PathVariable("environment") String environment) {
        try {

            Application applicationEnum = applicationRepository.findByApplication(EApplication.valueOf(application))
                    .orElseThrow(() -> new RuntimeException("Error: Application is not found."));

            Environment environmentEnum = environmentRepository.findByEnvironment(EEnvironment.valueOf(environment))
                    .orElseThrow(() -> new RuntimeException("Error: Environment is not found."));

            List<Event> events = eventRepository.findByApplicationAndEnvironment(applicationEnum, environmentEnum);

            if (events.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = { "/applications" })
    public List<Application> getApplications() throws IOException {
        return applicationRepository.findAll();
    }

    @GetMapping(path = { "/environments" })
    public List<Environment> getEnvironments() throws IOException {
        return environmentRepository.findAll();
    }

    @GetMapping(path = { "/authors" })
    public List<Author> getAuthors() throws IOException {
        return authorRepository.findAll();
    }

//    @PostMapping("/tutorials")
//    public ResponseEntity<Tutorial> createTutorial(@RequestBody Tutorial tutorial) {
//        try {
//            Tutorial _tutorial = eventRepository
//                    .save(new Tutorial(tutorial.getTitle(), tutorial.getDescription(), false));
//            return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
}
