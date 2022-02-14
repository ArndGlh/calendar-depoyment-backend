package com.bezkoder.spring.datajpa.model;

import org.hibernate.annotations.Cascade;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn( name="idAuthor" )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Author author;

    @Column(name = "start")
    private Date start;

    @Column(name = "end")
    private Date end;

    @ManyToOne
    @JoinColumn( name="idEnvironment" )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Environment environment;

    @ManyToOne
    @JoinColumn( name="idApplication" )
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Application application;

    public Event() {

    }
}