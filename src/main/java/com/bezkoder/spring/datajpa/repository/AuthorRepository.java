package com.bezkoder.spring.datajpa.repository;

import com.bezkoder.spring.datajpa.model.Author;
import com.bezkoder.spring.datajpa.model.enums.EAuthor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findAll();
    Optional<Author> findByAuthor(EAuthor eAuthor);
}