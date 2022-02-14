package com.bezkoder.spring.datajpa.model;

import com.bezkoder.spring.datajpa.model.enums.EAuthor;
import org.hibernate.annotations.Cascade;
import javax.persistence.*;

@Entity
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthor;

    @Enumerated(EnumType.STRING)
    @Column(length = 30)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private EAuthor author;

    public Author(){}

    public Author(EAuthor author) {
        this.author = author;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public EAuthor getAuthor() {
        return author;
    }

    public void setAuthor(EAuthor author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", author=" + author +
                '}';
    }
}

